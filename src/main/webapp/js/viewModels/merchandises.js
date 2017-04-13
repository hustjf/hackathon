/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your customer ViewModel code goes here
 */
define(['ojs/ojcore', 'knockout', 'jquery', 'ojs/ojknockout', 'promise', 'ojs/ojlistview',
        'ojs/ojmodel', 'ojs/ojgauge', 'ojs/ojbutton', 'ojs/ojcheckboxset',
        'ojs/ojselectcombobox', 'ojs/ojpagingcontrol', 'ojs/ojcollectiontabledatasource', 'ojs/ojpagingtabledatasource','ojs/ojdialog'],
 function(oj, ko, $) {
  
    function CustomerViewModel() {
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

        var criteriaMap = {};
        criteriaMap['lh'] = {key: 'PRICE', direction: 'ascending'};
        criteriaMap['hl'] = {key: 'PRICE', direction: 'descending'};
        criteriaMap['reviews'] = {key: 'REVIEWS', direction: 'descending'};
        criteriaMap['date'] = {key: 'PUBLISH_DATE', direction: 'ascending'};

        var filters = ['lt100', '100to1000', '1000to5000', 'gt5000', 'five', 'four', 'three', 'two', 'apple', 'dell', 'lenovo', 'hp', 'epson', 'tc', 'md', 'computer', 'printer', 'marker', 'paper'];

        var filterFunc = {};
        filterFunc['lt100'] = function(model) { return (parseFloat(model.get('PRICE')) < 100); };
        filterFunc['100to1000'] = function(model) { return (parseFloat(model.get('PRICE')) > 100 && parseFloat(model.get('PRICE')) < 1000); };
        filterFunc['1000to5000'] = function(model) { return (parseFloat(model.get('PRICE')) >= 1000 && parseFloat(model.get('PRICE')) <= 5000); };
        filterFunc['gt5000'] = function(model) { return (parseFloat(model.get('PRICE')) > 5000); };

        filterFunc['five'] = function(model) { return (parseFloat(model.get('RATING')) == 5); };
        filterFunc['four'] = function(model) { return (parseFloat(model.get('RATING')) >= 4); };
        filterFunc['three'] = function(model) { return (parseFloat(model.get('RATING')) >= 3); };
        filterFunc['two'] = function(model) { return (parseFloat(model.get('RATING')) < 3); };

        filterFunc['apple'] = function(model) { return (model.get('AUTHOR').indexOf('Apple') > -1); };
        filterFunc['dell'] = function(model) { return (model.get('AUTHOR').indexOf('Dell') > -1); };
        filterFunc['lenovo'] = function(model) { return (model.get('AUTHOR').indexOf('Lenovo') > -1); };
        filterFunc['hp'] = function(model) { return (model.get('AUTHOR').indexOf('HP') > -1); };
        filterFunc['epson'] = function(model) { return (model.get('AUTHOR').indexOf('EPSON') > -1); };
        filterFunc['tc'] = function(model) { return (model.get('AUTHOR').indexOf('Touchlitt3') > -1); };
        filterFunc['md'] = function(model) { return (model.get('AUTHOR').indexOf('M&D') > -1); };
        
        filterFunc['computer'] = function(model) { return (model.get('TYPE').indexOf('Computer') > -1); };
        filterFunc['printer'] = function(model) { return (model.get('TYPE').indexOf('Printer') > -1); };
        filterFunc['marker'] = function(model) { return (model.get('TYPE').indexOf('Marker') > -1); };
        filterFunc['paper'] = function(model) { return (model.get('TYPE').indexOf('Paper') > -1); };

        var converterFactory = oj.Validation.converterFactory("number");
        var currencyOptions =
            {
                style: "currency",
                currency: "RMB",
                currencyDisplay:"symbol"
            };
        this.currencyConverter = converterFactory.createConverter(currencyOptions);

        var model = oj.Model.extend({
            idAttribute: 'ID'
        });

        this.collection = new oj.Collection(null, {
            url: 'productData.json',
            model: model
        });
        var originalCollection = this.collection;

        this.dataSource = ko.observable(new oj.PagingTableDataSource(new oj.CollectionTableDataSource(this.collection)));

        this.currentPrice = [];
        this.currentAuthor = [];
        this.currentRating = [];
        this.currentSort = ko.observable("default");

        var self = this;
        this.handleSortCriteriaChanged = function(event, ui)
        {
            if (ui.option != 'value' || (ui.value.length == 1 && ui.value[0] == 'default'))
            {
                return;
            }

            var criteria = criteriaMap[ui.value];
            self.dataSource().sort(criteria);
        };

        this.handleFilterChanged = function(event, ui)
        {
            if (ui.option != 'value')
            {
                return;
            }

            var value = ui.value;
            if (!Array.isArray(value))
            {
                return;
            }

            var results = [];
            var processed = false;

            $.each(filters, function(index, filter)
            {
                if (value.indexOf(filter) > -1)
                {
                    results = results.concat(originalCollection.filter(filterFunc[filter]));
                    processed = true;
                }
            });

            if (processed)
            {
                self.collection = new oj.Collection(results);
            }
            else
            {
                self.collection = originalCollection;
            }
            self.dataSource(new oj.PagingTableDataSource(new oj.CollectionTableDataSource(self.collection)));

            if (self.currentSort() != "default")
            {
                var criteria = criteriaMap[self.currentSort()];
                self.dataSource().sort(criteria);
            }
        };
       

        self.addtocart =function(data, event){

        }


    }


    /*
     * Returns a constructor for the ViewModel so that the ViewModel is constrcuted
     * each time the view is displayed.  Return an instance of the ViewModel if
     * only one instance of the ViewModel is needed.
     */
    return new CustomerViewModel();
  }
);
