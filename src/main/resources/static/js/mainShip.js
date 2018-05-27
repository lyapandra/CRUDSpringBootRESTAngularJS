var app = angular.module("ShipManagement", []);

// Controller Part
app.controller("ShipController", function($scope, $http) {

// Start Form Data
    $scope.ships = [];
    $scope.shipForm = {
        shipId: 2,
        shipNo: "",
        shipName: ""
    };

    // Now load the data from server
    _refreshShipData();

    // HTTP POST/PUT methods for add/edit ship
    // Call: http://localhost:8080/ship
    $scope.submitShip = function() {

        var method = "";
        var url = "";

        if ($scope.shipForm.shipId == -1) {
            method = "POST";
            url = '/ship';
        } else {
            method = "PUT";
            url = '/ship';
        }

        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.shipForm),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createShip = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete ship by Id
    // Call: http://localhost:8080/ship/{empId}
    $scope.deleteShip = function(ship) {
        $http({
            method: 'DELETE',
            url: '/ship/' + ship.shipId
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editShip = function(ship) {
        $scope.shipForm.shipId = ship.shipId;
        $scope.shipForm.shipNo = ship.shipNo;
        $scope.shipForm.shipName = ship.shipName;
    };

    // Private Method
    // HTTP GET- get all ships collection
    // Call: http://localhost:8080/ships
    function _refreshShipData() {
        $http({
            method: 'GET',
            url: '/ships'
        }).then(
            function(res) { // success
                $scope.ships = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshShipData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.shipForm.shipId = -1;
        $scope.shipForm.shipNo = "";
        $scope.shipForm.shipName = ""
    };
});