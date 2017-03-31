/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your dashboard ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout', 'promise', 'ojs/ojtable', 'ojs/ojarraytabledatasource', 'ojs/ojbutton'],
 function(oj, ko, $) {
  
    function DashboardViewModel() {
      var self = this;
      // Below are a subset of the ViewModel methods invoked by the ojModule binding
      // Please reference the ojModule jsDoc for additionaly available methods.

      /**
       * Optional ViewModel method invoked when this ViewModel is about to be
       * used for the View transition.  The application can put data fetch logic
       * here that can return a Promise which will delay the handleAttached function
       * call below until the Promise is resolved.
       * @param {Object} info - An object with the following key-value pairs:
       * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
       * @param {Function} info.valueAccessor - The binding's value accessor.
       * @return {Promise|undefined} - If the callback returns a Promise, the next phase (attaching DOM) will be delayed until
       * the promise is resolved
       */
      self.handleActivated = function(info) {
        // Implement if needed
      };

      /**
       * Optional ViewModel method invoked after the View is inserted into the
       * document DOM.  The application can put logic that requires the DOM being
       * attached here.
       * @param {Object} info - An object with the following key-value pairs:
       * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
       * @param {Function} info.valueAccessor - The binding's value accessor.
       * @param {boolean} info.fromCache - A boolean indicating whether the module was retrieved from cache.
       */
      self.handleAttached = function(info) {
        // Implement if needed
      };


      /**
       * Optional ViewModel method invoked after the bindings are applied on this View. 
       * If the current View is retrieved from cache, the bindings will not be re-applied
       * and this callback will not be invoked.
       * @param {Object} info - An object with the following key-value pairs:
       * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
       * @param {Function} info.valueAccessor - The binding's value accessor.
       */
      self.handleBindingsApplied = function(info) {
        // Implement if needed
      };

      /*
       * Optional ViewModel method invoked after the View is removed from the
       * document DOM.
       * @param {Object} info - An object with the following key-value pairs:
       * @param {Node} info.element - DOM element or where the binding is attached. This may be a 'virtual' element (comment node).
       * @param {Function} info.valueAccessor - The binding's value accessor.
       * @param {Array} info.cachedNodes - An Array containing cached nodes for the View if the cache is enabled.
       */
      self.handleDetached = function(info) {
        // Implement if needed
      };

        var dataArray = [{sku: 'IPhone7', price: 699, catalog: 'Phone', unit: 1, supplier: "Apple"},
            {sku: 'IPad2', price: 399, catalog: 'Computer', unit: 3, supplier: "Apple"},
            {sku: 'MacBook Pro', price: 2199, catalog: 'Computer', unit: 5, supplier: "Apple"},
            {sku: 'Apple Watch2', price: 349, catalog: 'Watch', unit: 6, supplier: "Apple"},
            {sku: 'IMac', price: 1799, catalog: 'Computer', unit: 2, supplier: "Apple"}];

        self.datasource = new oj.ArrayTableDataSource(dataArray, {idAttribute: 'materialsid'});

        self.button_getdata = function(data, event){
            $.ajax({
                url: "./rest/stock",
                type: "GET",
                data: {},
                dataType: "",
                success: function (response, textStatus) {
                    self.datasource = new oj.ArrayTableDataSource(response, {idAttribute: 'materialsid'});
                    $('#table').ojTable({"data" : self.datasource});
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.responseText);
                }
            });
            return true;
        };

        self.button_adddata = function(data, event){
            $.ajax({
                url: "./rest/crud",
                type: "POST",
                data: JSON.stringify({sku: 'IMac', price: 1799, catalog: 'Computer', unit: 2, supplier: "Apple"}),
                dataType: "",
                contentType: "application/json",
                success: function (response, textStatus) {
                    alert("add success!");
                    self.button_getdata();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.responseText);
                }
            });
            return true;
        }
    }

    /*
     * Returns a constructor for the ViewModel so that the ViewModel is constrcuted
     * each time the view is displayed.  Return an instance of the ViewModel if
     * only one instance of the ViewModel is needed.
     */
    return new DashboardViewModel();
  }
);
