angular.module('myApp')
.factory('AuthoritiesService', function ($http, Constant) {
    const url = Constant.BASE_URL+"/authorities"

    const action = {
        removeAuthorities: removeAuthorities,
        addAuthorities: addAuthorities
    }

    return action;

    function addAuthorities(data) {
        return $http.post(url, data).then(resp => resp)
    }

    function removeAuthorities(data) {
        return $http({
                method: 'delete',
                url: url,
                data: data,
                headers: {
                    'content-type': 'application/json'
                }
            })
            .then(resp => resp)
    }
})