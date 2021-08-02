angular.module("myApp", [])
.factory("CartService", function($http) {

    const url = "/thao-van/api";

    let caller = {}

    const actions = {
        setCaller: setCaller,
        addToCart: addToCart,
        removeInCart: removeInCart,
        removeAll: removeAll,
        loadFromLocalStorage: loadFromLocalStorage
    }

    return actions;

    function setCaller(cl) {
        caller = cl
    }

    function addToCart(itemId) {
        $http.get(`${url}/products/${itemId}`)
            .then(resp => resp.data)
            .then(i => {
                const data = caller.items.find(i => i.id === itemId)

                if (data)
                    data.quantity++;
                else {
                    const item = {...i,quantity: 1}
                    caller.amount++
                    caller.items.push(item)
                }
                calTotal()
                saveToLocalStorage();
            })
    }

    function removeInCart(itemId) {
        caller.items = caller.items.filter(i => i.id !== itemId)
        calTotal()
        saveToLocalStorage()
    }

    function removeAll() {
        caller.items = []
        caller.amount = 0
        caller.total = 0
        saveToLocalStorage()
    }

    function saveToLocalStorage() {
        localStorage.setItem("items", JSON.stringify(caller.items))
    }

    function loadFromLocalStorage() {
        caller.items = JSON.parse(localStorage.getItem("items")) || []
        caller.amount = caller.items.length
        calTotal()
    }

    function calTotal() {
        if (caller.total)
            caller.total = caller.items.map(item => item.price * item.quantity).reduce((total, index) => total + index)
    }

})