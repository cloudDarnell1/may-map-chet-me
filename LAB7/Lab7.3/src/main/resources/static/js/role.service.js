angular.module('myApp')
.factory('RoleService', function ($http, Constant) {
    var url = Constant.BASE_URL + '/roles'
    var actions = {
        findAll: findAll
    }

    return actions;

    function findAll() {
        return $http.get(url).then(resp => resp.data)
    }
})