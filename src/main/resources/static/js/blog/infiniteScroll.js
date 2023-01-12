/*
Infinite Scroll v 1.0.4
https://github.com/marshall-ku/Infinite-Scroll
Released under the MIT License.
by Marshall K
*/

function infiniteScroll({
                            container,
                            next,
                            prev,
                            item,
                            nextButton,
                            prevButton,
                            nextLoader,
                            prevLoader,
                            pushHistory,
                            detectLoad,
                            onLoadFinish,
                            nextCallback,
                            prevCallback,
                            autoPrev
                        }) {
    const windowHeight = window.innerHeight;
    const containerElem = document.querySelector(container);
    const nextElem = document.querySelector(next);
    const prevElem = document.querySelector(prev);
    const loaderElem = {
        next: nextLoader && document.querySelector(nextLoader),
        prev: prevLoader && document.querySelector(prevLoader)
    };
    const prevArray = [];
    const reveal = "reveal";
    let loadingNext = false;
    let loadingPrev = false;
    let SCROLLY = (window.scrollY || window.pageYOffset);
    let TICKING = false;

    function init() {
        if (!container || !next || !item) {
            throw "Initial Elements are Missing!"
        }
        nextButton && (nextButton = document.querySelector(nextButton)),
        prevButton && (prevButton = document.querySelector(prevButton)),
            nextElem === null ? noMoreNext() : "" === nextElem.getAttribute("href") && noMoreNext(),
            prevElem === null ? noMorePrev() : "" === prevElem.getAttribute("href") && noMorePrev(),
        detectLoad === undefined && (detectLoad = true)
    }

    function noMoreNext() {
        nextElem.classList.add("done"),
            nextElem.removeAttribute("href"),
        nextLoader && (loaderElem.next.style.display = "none"),
        nextButton && (nextButton.style.display = "none")
    }

    function noMorePrev() {
        prevElem.classList.add("done"),
            prevElem.removeAttribute("href"),
        prevLoader && (loaderElem.prev.style.display = "none"),
        prevButton && (prevButton.style.display = "none")
    }

    function nextPage() {
        const d = document.querySelector(next);

        if (null === d || !0 === loadingNext || d.classList.contains("done")) return;

        let imgLength = 0;
        let loadedImg = 0;
        const uri = d.href;
        const loadEnd = () => {
            imgLength === loadedImg && (
                pushHistory && history.pushState(null, null, uri),
                nextLoader && loaderElem.next.classList.remove(reveal),
                nextButton && !nextElem.classList.contains("done") && (nextButton.style.display = ""),
                    loadingNext = !1,
                onLoadFinish && onLoadFinish()
            )
        };

        loadingNext = !0,
        nextLoader && loaderElem.next.classList.add(reveal),
        nextButton && (nextButton.style.display = "none"),

            fetch(uri)
                .then(response => {
                    const status = response.status;
                    if (status === 200) {
                        return response.text();
                    }
                    else if (status === 404) {
                        noMoreNext();
                    }
                    else {
                        return;
                    }
                })
                .then(a => {
                    const parser = new DOMParser().parseFromString(a, "text/html"),
                        items = parser.querySelectorAll(item);

                    null === parser.querySelector(next)
                        ? (
                            noMoreNext()
                        )
                        : (
                            parser.querySelector(next).getAttribute("href") === ""
                                ? (
                                    noMoreNext()
                                )
                                : (d.href = parser.querySelector(next).href)
                        ),

                        detectLoad
                            ? (
                                [...items].forEach(element => {
                                    element.querySelector("img") && (
                                        [...element.querySelectorAll("img")].forEach(a => {
                                            imgLength++,
                                                a.onload = () => {
                                                    loadedImg++,
                                                        loadEnd()
                                                }
                                        })
                                    ),
                                        containerElem.append(element),
                                    nextCallback && nextCallback(element)
                                })
                            )
                            : (
                                [...items].forEach(element => {
                                    containerElem.append(element),
                                    pushHistory && history.pushState(null, null, uri),
                                    nextCallback && nextCallback(element)
                                }),
                                    loadingNext = false,
                                nextLoader && loaderElem.next.classList.remove(reveal),
                                nextButton && (nextButton.style.display = "")
                            )
                })
                .catch(err => {
                    console.log(err)
                })
    }

    function prevPage() {
        const d = document.querySelector(prev);

        if (null === d || !0 === loadingPrev || d.classList.contains("done")) return;

        let isFirstPage = !1;
        let imgLength = 0;
        let loadedImg = 0;
        const uri = d.href;
        const loadEnd = () => {
            imgLength === loadedImg && (
                prevLoader && loaderElem.prev.classList.remove(reveal),
                    loadingPrev = !1,
                prevButton && !prevElem.classList.contains("done") && (prevButton.style.display = ""),
                onLoadFinish && onLoadFinish()
            )
        };

        loadingPrev = !0,
        prevLoader && loaderElem.prev.classList.add(reveal),
        prevButton && (prevButton.style.display = "none"),

            fetch(uri)
                .then(response => {
                    const status = response.status;
                    if (status === 200) {
                        return response.text();
                    }
                    else if (status === 404) {
                        isFirstPage = !0,
                            noMorePrev();

                        return !1;
                    }
                    else {
                        return !1;
                    }
                })
                .then(a => {
                    const parser = new DOMParser().parseFromString(a, "text/html"),
                        items = parser.querySelectorAll(item);

                    isFirstPage = autoPrev && (isFirstPage ? !0 : (null === parser.querySelector(prev) ? !0 : (parser.querySelector(prev).getAttribute("href") === "")));

                    null === parser.querySelector(prev)
                        ? (
                            noMorePrev()
                        )
                        : (
                            parser.querySelector(prev).getAttribute("href") === ""
                                ? (
                                    noMorePrev()
                                )
                                : (d.href = parser.querySelector(prev).href)
                        ),

                        autoPrev
                            ? (
                                isFirstPage
                                    ? (
                                        noMorePrev()
                                    )
                                    : (d.href = parser.querySelector(prev).href),

                                    [...parser.querySelectorAll(item)].reverse().forEach(element => {
                                        prevArray.push(element)
                                    }),

                                    isFirstPage
                                        ? (
                                            detectLoad
                                                ? (
                                                    prevArray.forEach(element => {
                                                        element.querySelector("img") && (
                                                            [...element.querySelectorAll("img")].forEach(a => {
                                                                imgLength++,
                                                                    a.onload = () => {
                                                                        loadedImg++,
                                                                            loadEnd()
                                                                    }
                                                            })
                                                        ),
                                                            containerElem.prepend(element),
                                                        prevCallback && prevCallback(element)
                                                    })
                                                )
                                                : (
                                                    prevArray.forEach(element => {
                                                        containerElem.prepend(element),
                                                        prevCallback && prevCallback(element)
                                                    })
                                                )
                                        )
                                        : (
                                            loadingPrev = !1,
                                                prevPage()
                                        )
                            )
                            : (
                                detectLoad
                                    ? (
                                        [...items].reverse().forEach(element => {
                                            element.querySelector("img") && (
                                                [...element.querySelectorAll("img")].forEach(a => {
                                                    imgLength++,
                                                        a.onload = () => {
                                                            loadedImg++,
                                                                loadEnd()
                                                        }
                                                })
                                            ),
                                                containerElem.prepend(element),
                                            prevCallback && prevCallback(element)
                                        })
                                    )
                                    : (
                                        [...items].reverse().forEach(element => {
                                            containerElem.prepend(element),
                                            pushHistory && history.pushState(null, null, uri),
                                            prevCallback && prevCallback(element)
                                        }),
                                            loadingPrev = false,
                                        prevLoader && loaderElem.prev.classList.remove(reveal)
                                    )
                            )
                })
                .catch(err => {
                    console.log(err)
                })
    }

    function handlePageLoad() {
        const offsetTop = containerElem.offsetTop;
        !nextButton && null !== nextElem && "" !== nextElem.getAttribute("href") && !loadingNext && SCROLLY >= offsetTop + containerElem.scrollHeight - windowHeight - 500 && nextPage(),
        !prevButton && null !== prevElem && "" !== prevElem.getAttribute("href") && !loadingPrev && SCROLLY <= offsetTop + 500 && prevPage()
    }

    init(),
    !prevButton && autoPrev && prevPage(),
        handlePageLoad(),

        window.addEventListener("scroll", () => {
            TICKING || (
                window.requestAnimationFrame(() => {
                    SCROLLY = (window.scrollY || window.pageYOffset),
                        handlePageLoad(),
                        TICKING = false
                }),
                    TICKING = true
            )
        }),

    nextButton && (
        nextButton.addEventListener("click", () => {
            nextPage()
        })
    ),
    prevButton && (
        prevButton.addEventListener("click", () => {
            prevPage()
        })
    )
}