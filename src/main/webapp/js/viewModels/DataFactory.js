/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
/*
 * Your dashboard ViewModel code goes here
 */
define(['ojs/ojcore'],
 function(oj) {

  var DataFactory = {
    resourceUrl: "http://movieapp-sitepointdemos.rhcloud.com/api/movies",

    // Create a single movie instance.
    createDataModel: function() {
      var Data = oj.Model.extend({urlRoot:     this.resourceUrl,
                                   idAttribute: "_id"});
      return new Data();
    },

    // Create a movie collection.
    createDataCollection: function() {
      var Datas = oj.Collection.extend({url:   this.resourceUrl,
                                         model: this.createDataModel()});
      return new Datas();
    }
  }

  return DataFactory;
});