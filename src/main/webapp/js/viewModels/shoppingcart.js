/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your incidents ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout', 'promise', 'ojs/ojtable', 'ojs/ojarraytabledatasource', 'ojs/ojbutton'],
 function(oj, ko, $) {
  
    function IncidentsViewModel() {
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
	  
			
        var dataArray1 = [
			{supplier: 'met', phone: 699, email: '**@qq.com', contact: 'p1'},
			{supplier: 'met', phone: 699, email: '**@qq.com', contact: 'p1'},
			{supplier: 'met', phone: 699, email: '**@qq.com', contact: 'p1'},
			{supplier: 'met', phone: 699, email: '**@qq.com', contact: 'p1'}];

        self.datasource1 = new oj.ArrayTableDataSource(dataArray1, {idAttribute: 'supplier'});
		
        var dataArray = [
			{metname: 'met', materialsid: 699, unit: 1, sku: 'IPhone', price: 699, supplier: "Lenovo"},
            {metname: 'met', materialsid: 699, unit: 1, sku: 'IPhone', price: 699, supplier: "Lenovo",materialID:"2016311"},
            {metname: 'met', materialsid: 699, unit: 1, sku: 'IPhone', price: 699, supplier: "Lenovo",materialID:"2016312"},
            {metname: 'met', materialsid: 699, unit: 1, sku: 'IPhone', price: 699, supplier: "Lenovo",materialID:"2017316"},
            {metname: 'met', materialsid: 699, unit: 1, sku: 'IPhone', price: 699, supplier: "Lenovo",materialID:"2017318"},
            {metname: 'met', materialsid: 699, unit: 1, sku: 'IPhone', price: 699, supplier: "Lenovo"},
            {metname: 'met', materialsid: 699, unit: 1, sku: 'IPhone', price: 699, supplier: "Lenovo"}];

        self.datasource = new oj.ArrayTableDataSource(dataArray, {idAttribute: 'sku'});
			

    }
	
    /*
     * Returns a constructor for the ViewModel so that the ViewModel is constrcuted
     * each time the view is displayed.  Return an instance of the ViewModel if
     * only one instance of the ViewModel is needed.
     */
    return new IncidentsViewModel();
  }
);
