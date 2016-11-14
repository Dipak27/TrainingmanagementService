      mainApp.controller('AppController', [function() {
          var self = this;
          self.name='';
          self.message= 'Hello';
          self.changeMessage = function() {
              self.message = 'Bye';
          };
          self.resetMessage = function() {
              self.message = 'Hello';
          };
      }]);