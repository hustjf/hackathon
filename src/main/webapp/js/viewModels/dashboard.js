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

        self.updatematerialsid = "";
        self.updatecurrentstock = "";
        self.updatematname = "";
        self.updateprice = "";
        self.updatesave = "";
        self.updatesuk = "";
        self.updatesupplier = "";
        self.updatetotalstock = "";
        self.updatetype = "";
        self.updateunit = "";
        self.addmaterialsid = "";
        self.addcurrentstock = "";
        self.addmatname = "";
        self.addprice = "";
        self.addsave = "";
        self.addsuk = "";
        self.addsupplier = "";
        self.addtotalstock = "";
        self.addtype = "";
        self.addunit = "";

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
            var val = eval('(' + checkedArray[0] + ')');
            $('#input_updatematerialsid').ojInputText({"value" : val["materialsid"]});
            $('#input_updatecurrentstock').ojInputText({"value" : val["currentstock"]});
            $('#input_updatematname').ojInputText({"value" : val["matname"]});
            $('#input_updateprice').ojInputText({"value" : val["price"]});
            $('#input_updatesave').ojInputText({"value" : val["save"]});
            $('#input_updatesuk').ojInputText({"value" : val["suk"]});
            $('#input_updatesupplier').ojInputText({"value" : val["supplier"]});
            $('#input_updatetotalstock').ojInputText({"value" : val["totalstock"]});
            $('#input_updatetype').ojInputText({"value" : val["type"]});
            $('#input_updateunit').ojInputText({"value" : val["unit"]});
            self.updatematerialsid = val["materialsid"];
            self.updatecurrentstock = val["currentstock"];
            self.updatematname = val["matname"];
            self.updateprice = val["price"];
            self.updatesave = val["save"];
            self.updatesuk = val["suk"];
            self.updatesupplier = val["supplier"];
            self.updatetotalstock = val["totalstock"];
            self.updatetype = val["type"];
            self.updateunit = val["unit"];

            return true;
        };

        self.button_adddata = function(data, event){
            if (self.addmaterialsid === "" || self.addcurrentstock === "" || self.addmatname === "" || self.addprice === "" || self.addsave === "" || self.addsuk === "" || self.addsupplier === "" || self.addtotalstock === "" || self.addtype === "" || self.addunit === "") {
                alert("Please input all value!");
                return;
            }
            $.ajax({
                url: "./rest/stock",
                type: "POST",
                data: JSON.stringify({materialsid: self.addmaterialsid, currentstock: self.addcurrentstock, matname: self.addmatname, price: self.addprice, save: self.addsave, suk: self.addsuk, supplier: self.addsupplier, totalstock: self.addtotalstock, type: self.addtype, unit: self.addunit}),
                dataType: "",
                contentType: "application/json",
                success: function (response, textStatus) {
                    alert("Add Success!");
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
                    self.addmaterialsid = "";
                    self.addcurrentstock = "";
                    self.addmatname = "";
                    self.addprice = "";
                    self.addsave = "";
                    self.addsuk = "";
                    self.addsupplier = "";
                    self.addtotalstock = "";
                    self.addtype = "";
                    self.addunit = "";
                    $("#addDialog").ojDialog("close");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.responseText);
                }
            });
            return true;
        };

        self.button_updatedata = function(data, event){
            $.ajax({
                url: "./rest/stock",
                type: "PUT",
                data: JSON.stringify({materialsid: self.updatematerialsid, currentstock: self.updatecurrentstock, matname: self.updatematname, price: self.updateprice, save: self.updatesave, suk: self.updatesuk, supplier: self.updatesupplier, totalstock: self.updatetotalstock, type: self.updatetype, unit: self.updateunit}),
                dataType: "",
                contentType: "application/json",
                success: function (response, textStatus) {
                    alert("Update Success!");
                    self.button_getdata();
                    $("#updateDialog").ojDialog("close");
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    alert(XMLHttpRequest.responseText);
                }
            });
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
                    alert("Delete Success!");
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
