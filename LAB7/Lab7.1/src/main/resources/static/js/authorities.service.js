angular.module('myApp')
.factory('AuthoritiesService', function ($http, Constant) {
    const url = Constant.URL+"/authorities"

    const action = {
    }

    return action;

    function addAuthorities(data) {
        return $http.post(url, data).then(resp => resp)
    }

    function removeAuthorities(data) {
        return $http.delete(url, data).then(resp => resp)
    }
})