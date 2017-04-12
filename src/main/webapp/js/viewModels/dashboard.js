/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your dashboard ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout', 'promise', 'ojs/ojtable', 'ojs/ojarraytabledatasource', 'ojs/ojbutton', 'ojs/ojdialog', 'ojs/ojinputtext'],
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

        // var dataArray = [{materialsid: 123, currentstock: 123, matname: "haha", price: 123, save: 123, suk: "haha", supplier: "haha", totalstock: 123, type: "haha", unit: "haha"}];

        self.datasource = null;

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

        self.materialsid = "";
        self.currentstock = "";
        self.matname = "";
        self.price = "";
        self.save = "";
        self.suk = "";
        self.supplier = "";
        self.totalstock = "";
        self.type = "";
        self.unit = "";

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

        self.button_openAddDialog = function(data, event){
            $("#addDialog").ojDialog("open");
            return true;
        };

        self.button_openUpdateDialog = function(data, event){
            var checkedArray = self.findChecked();
            if (checkedArray.length != 1) {
                alert("Please select only one data to update!");
                return;
            }
            $("#updateDialog").ojDialog("open");
            return true;
        };

        self.button_adddata = function(data, event){
            if (self.materialsid === "" || self.currentstock === "" || self.matname === "" || self.price === "" || self.save === "" || self.suk === "" || self.supplier === "" || self.totalstock === "" || self.type === "" || self.unit === "") {
                alert("Please input all value!");
                return;
            }
            $.ajax({
                url: "./rest/stock",
                type: "POST",
                data: JSON.stringify({materialsid: self.materialsid, currentstock: self.currentstock, matname: self.matname, price: self.price, save: self.save, suk: self.suk, supplier: self.supplier, totalstock: self.totalstock, type: self.type, unit: self.unit}),
                dataType: "",
                contentType: "application/json",
                success: function (response, textStatus) {
                    alert("add success!");
                    self.button_getdata();
                    $('#input_addmaterialsid').ojInputText({"value" : ""});
                    $('#input_addcurrentstock').ojInputText({"value" : ""});
                    $('#input_addmatname').ojInputText({"value" : ""});
                    $('#input_addprice').ojInputText({"value" : ""});
                    $('#input_addsave').ojInputText({"value" : ""});
                    $('#input_addsuk').ojInputText({"value" : ""});
                    $('#input_addsupplier').ojInputText({"value" : ""});
                    $('#input_addtotalstock').ojInputText({"value" : ""});
                    $('#input_addtype').ojInputText({"value" : ""});
                    $('#input_addunit').ojInputText({"value" : ""});
                    self.materialsid = "";
                    self.currentstock = "";
                    self.matname = "";
                    self.price = "";
                    self.save = "";
                    self.suk = "";
                    self.supplier = "";
                    self.totalstock = "";
                    self.type = "";
                    self.unit = "";
                    $("#addDialog").ojDialog("close");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.responseText);
                }
            });
            return true;
        };

        self.button_updatedata = function(data, event){
            // $.ajax({
            //     url: "./rest/stock",
            //     type: "PUT",
            //     data: checkedArray[0],
            //     dataType: "",
            //     contentType: "application/json",
            //     success: function (response, textStatus) {
            //         self.datasource = new oj.ArrayTableDataSource(response, {idAttribute: 'materialsid'});
            //         $('#table').ojTable({"data" : self.datasource});
            //     },
            //     error: function (XMLHttpRequest, textStatus, errorThrown) {
            //         alert(XMLHttpRequest.responseText);
            //     }
            // });
            return true;
        };

        self.findChecked = function() {
            var selectedArray = [];
            $("input:checkbox").each(function() {
                var $this = $(this);
                if ($this.is(":checked")) {
                    // alert($this.attr("value"));
                    selectedArray.push($this.attr("value"));
                }
            });
            return selectedArray;
        };

        self.button_deletedata = function(data, event){
            var checkedArray = self.findChecked();
            if (checkedArray.length == 0) {
                alert("Please select at least one data to delete!");
                return;
            }
            $.ajax({
                url: "./rest/stock",
                type: "DELETE",
                data: JSON.stringify(eval('(' + checkedArray[0] + ')')),
                dataType: "",
                contentType: "application/json",
                success: function (response, textStatus) {
                    alert("Delete success!");
                    self.button_getdata();
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.responseText);
                }
            });
            return true;
        };
    }

    /*
     * Returns a constructor for the ViewModel so that the ViewModel is constrcuted
     * each time the view is displayed.  Return an instance of the ViewModel if
     * only one instance of the ViewModel is needed.
     */
    return new DashboardViewModel();
  }
);
