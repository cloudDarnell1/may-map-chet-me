angular.module('myApp')
.controller('myController' , function(CartService, $http, $scope) {

    (function start() {
        CartService.setCaller($scope)
        CartService.loadFromLocalStorage()
    })()

    $scope.add = function(itemId) {
        CartService.addToCart(itemId)
    }

    $scope.clear = function () {
        CartService.removeAll()
    }

    $scope.remove = function(id) {
        CartService.removeInCart(id)
    }

    $scope.order = {
        address: "",
        createDate: new Date(),
        customer: $('#username').text().trim(),
        orderDetailsEntities: $scope.items.map(item => {
            return {
                productsEntity: item,
                price: item.price,
                quantity: item.quantity
            }
        }),
        purchase: function() {

            if ($scope.items.length === 0) {
                alert('Order at least on product')
                return;
            }

            const orderFake = angular.copy(this)

            $http.post('/thao-van/api/order', orderFake)
                .then(resp => {
                    alert('Order Successfully')
                    $scope.clear()
                    location.href = '/thao-van/order/detail/'+resp.data.id
                })
                .catch(() => alert('Order Failed!'))
        }
    }

})