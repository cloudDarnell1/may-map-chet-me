angular.module('myApp')
.controller('Lab7Controller', function ($scope, AccountService, RoleService, AuthoritiesService) {

    const vm = this;

    RoleService.findAll()
        .then(resp => vm.roles = resp)

    AccountService.findAll()
        .then(resp => vm.accounts = resp)

    vm.exist = function(account,role) {
        // check role exist or not in account
        return account.roles.filter(x => x.id === role.id).length !== 0
    }

    vm.deleteOrUpdate = function(event, username, roleId) {
        const element = event.target

        const data = {
            username: username,
            roleId: roleId
        }

        if (!element.checked) {
            AuthoritiesService.removeAuthorities(data).then(console.log)
            return;
        }
        AuthoritiesService.addAuthorities(data).then(console.log)
    }
});