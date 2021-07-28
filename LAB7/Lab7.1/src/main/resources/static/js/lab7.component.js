angular.module('myApp')
.controller('Lab7Controller', function ($scope, AccountService, RoleService, AuthoritiesService) {

    var vm = this;

    RoleService.findAll()
        .then(resp => vm.roles = resp)

    AccountService.findAll()
        .then(resp => vm.accounts = resp)

    vm.exist = function(account,role) {
        return account.roles.filter(x => x.id === role.id).length !== 0
    }

    vm.delete = function(a) {
        a.target
    }
});