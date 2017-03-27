/**
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates.
 * The Universal Permissive License (UPL), Version 1.0
 */
"use strict";
/*
 Copyright 2013 jQuery Foundation and other contributors
 Released under the MIT license.
 http://jquery.org/license
*/
define(["ojs/ojcore","jquery","ojs/ojcomponentcore"],function(a,g){(function(){a.Ra("oj.ojTrain",g.oj.baseComponent,{version:"1.0.0",defaultElement:"\x3cdiv\x3e",widgetEventPrefix:"oj",options:{steps:[],selected:"",optionChange:null,beforeDeselect:null,deselect:null,beforeSelect:null,select:null},Rg:0,fc:null,_ComponentCreate:function(){this._super();this.wda()},wda:function(){var a=this.options,c=a.steps;this.Rg=c.length;this.bk=g("\x3cdiv class\x3d'oj-train-wrapper'\x3e\x3c/div\x3e");this.bk.appendTo(this.element);
this.AI=g("\x3cdiv class\x3d'oj-train-connector-wrapper'\x3e\x3c/div\x3e");this.AI.appendTo(this.bk);var d=this.element.attr("class");(this.Tda=null!=d&&0<=d.indexOf("oj-train-stretch"))&&this.AI.css("padding","0 "+100/(2*this.Rg)+"%");this.D5=g("\x3cdiv class\x3d'oj-train-connector'\x3e\x3c/div\x3e");this.D5.appendTo(this.AI);this.lg=g("\x3cul\x3e");this.lg.addClass("oj-train-step-list");this.cS=g("\x3cdiv class\x3d'oj-train-connector-fill'\x3e\x3c/div\x3e");this.cS.appendTo(this.AI);this.oEa();
this.zn=this.bz(a.selected);-1===this.zn&&c[0]&&c[0].id&&(this.zn=0,a.selected=c[0].id);for(a=0;a<this.Rg;a++)c=g("\x3cli\x3e").addClass("oj-train-step-list-item").attr({id:this.fc[a][1]}),d=this.fc[a][4],"confirmation"===d?c.addClass("oj-confirmation"):"info"===d?c.addClass("oj-info"):"error"===d||"fatal"===d?c.addClass("oj-invalid"):"warning"===d&&c.addClass("oj-warning"),c.appendTo(this.lg),this.rta(a),this.uta(a),this.qta(a),this.pta(a),this.vta(a),this.sta(a),this.Tda&&c.css("width",100/this.Rg+
"%");this.cS.css({width:(this.Rg-1===this.zn?100:100/(2*(this.Rg-1))+this.zn/(this.Rg-1)*100)+"%"});this.lg.appendTo(this.bk);this.element.addClass("oj-train")},oEa:function(){var a=this.options;this.fc=[];for(var c=0;c<this.Rg;c++){var d=a.steps[c];this.fc[c]=Array(5);this.fc[c][0]=d.label?d.label:null;this.fc[c][1]=d.id?d.id:null;this.fc[c][2]=d.disabled?!0:!1;this.fc[c][3]=d.visited?!0:!1;this.fc[c][4]=d.messageType?d.messageType:null}},pta:function(a){var c=g("\x3cdiv/\x3e").addClass("oj-train-button"),
d=g("\x3cspan/\x3e"),e=this,f="";if(this.fc[a]){var h=this.fc[a][3],k=this.fc[a][2];this.zn===a?(c.addClass("oj-selected"),f=" current "):h&&!k?(c.addClass("oj-visited"),f=" visited "):h||k?c.addClass("oj-disabled"):(c.addClass("oj-default"),f=" not visited ");this.fc[a][2]||this.zn===a||(this.We(c),this.Gk(c),c.on("click"+this.eventNamespace,function(a){e.eJ("selected",e.options.selected,this.parentNode.parentNode.id,a);e.refresh()}));h=this.lg.children().eq(a).find(".oj-train-button-connector");
1<=h.length&&h.children().remove();h.append(c);d.text(f);d.addClass("oj-helper-hidden-accessible");this.lg.children().eq(a).find("a").append(d)}},sta:function(a){if(this.fc[a]&&this.fc[a][4]){var c=g("\x3cdiv/\x3e").addClass("oj-train-icon oj-component-icon"),d=g("\x3cspan/\x3e"),e="",f=this,h=this.fc[a][4];"confirmation"===h?(c.addClass("oj-confirmation"),e=" Confirmation "):"info"===h?(c.addClass("oj-info"),e=" Info "):"error"===h?(c.addClass("oj-error"),e=" Error "):"fatal"===h?(c.addClass("oj-error"),
e=" Error "):"warning"===h&&(c.addClass("oj-warning"),e=" Warning ");var k=this.lg.children().eq(a).find(".oj-train-button");2<=k.children().length&&k.children()[1].remove();if(!this.fc[a][2]&&this.zn!==a)c.on("click"+this.eventNamespace,function(a){f.eJ("selected",f.options.selected,this.parentNode.parentNode.parentNode.id,a);f.refresh()});null!=h&&(d.text(e),d.addClass("oj-helper-hidden-accessible"),this.lg.children().eq(a).find("a").append(d),k.append(c))}},eJ:function(a,c,d,e){a={option:a,fromStep:this.getStep(c),
toStep:this.getStep(d),optionMetadata:{writeback:e?"shouldWrite":"shouldNotWrite"}};!1!==this._trigger("beforeDeselect",e,a)&&!1!==this._trigger("beforeSelect",e,a)&&(c=this.bz(c),-1!==c&&(this.options.steps[c].visited=!0),this._trigger("deselect",e,a),this.option("selected",d,{_context:{originalEvent:e,kb:!0}}),this._trigger("select",e,a))},vta:function(a){var c=g("\x3cdiv/\x3e").addClass("oj-train-button-text");c.append((a+1).toString());this.lg.children().eq(a).find(".oj-train-button").append(c)},
qta:function(a){if(a!=this.Rg-1){var c=g("\x3cdiv/\x3e").addClass("oj-train-step-individual-connector");this.lg.children().eq(a).prepend(c)}},uta:function(a){var c=g("\x3cdiv/\x3e");c.addClass("oj-train-button-connector");this.fc[a]&&(a<=this.zn&&c.addClass("oj-train-fill"),a=this.lg.children().eq(a).children(),c.insertBefore(a))},rta:function(a){var c=this;if(this.fc[a]){var d=g("\x3cdiv/\x3e").addClass("oj-train-label-wrapper"),e=g("\x3ca\x3e");e.text(this.fc[a][0]);var f=this.fc[a][2];d.append(e);
e.addClass("oj-train-label");a===this.zn?e.addClass("oj-selected"):this.fc[a][3]&&!f?e.addClass("oj-visited"):f&&e.addClass("oj-disabled");f||(e.attr("href","#"),this.We(e),this.Gk(e),e.on("click keydown"+this.eventNamespace,function(a){if(a.keyCode===g.ui.keyCode.ENTER||"click"===a.type)a.preventDefault(),c.eJ("selected",c.options.selected,this.parentNode.parentNode.id,a),c.refresh(),a.keyCode===g.ui.keyCode.ENTER&&c.Zj(this.parentNode.parentNode.id)}));e=this.lg.children().eq(a).children();2<=e.length&&
e[1].remove();this.lg.children().eq(a).append(d)}},bz:function(a){for(var c=0;c<this.Rg;c++)if(this.fc[c]&&this.fc[c][1]===a)return c;return-1},getStep:function(a){for(var c=0;c<this.Rg;c++)if(this.fc[c]&&this.fc[c][1]===a)return g.extend({},this.options.steps[c]);return null},nextSelectableStep:function(){for(var a=this.bz(this.options.selected);a<this.Rg;a++)if(a+1<this.Rg&&this.fc[a+1]&&!this.fc[a+1][2])return this.fc[a+1][1];return null},previousSelectableStep:function(){for(var a=this.bz(this.options.selected);0<=
a;a--)if(this.fc[a-1]&&!this.fc[a-1][2])return this.fc[a-1][1];return null},setStep:function(a){if(a.id){var c=this.getStep(a.id),d=this.bz(a.id);-1!==d&&(d=this.options.steps[d],a.label&&(c[0]=a.label,d.label=a.label),"boolean"===typeof a.disabled&&(c[2]=a.disabled,d.disabled=a.disabled),"boolean"===typeof a.visited&&(c[3]=a.visited,d.visited=a.visited),a.messageType&&(c[4]=a.messageType,d.messageType=a.messageType));this.refresh()}},_setOptions:function(a){this._super(a);this.refresh()},_setOption:function(a,
c,d){"selected"===a&&this.options.selected&&this.fc&&this.fc[this.zn]&&this.eJ("selected",this.fc[this.zn][1],c,null);this._super(a,c,d)},refresh:function(){this._super();this._destroy();this.wda()},_destroy:function(){this.lg.children().each(function(){g(this).remove()});this.element.removeClass("oj-train");this.element.find(".oj-train-wrapper").remove();this.element.find(".oj-train-connector-wrapper").remove();this.element.find(".oj-train-step-list").remove();this.element.find(".oj-train-step-list").remove();
this._super()},Zj:function(a){a=this.bz(a);for(var c=0;c<this.Rg;c++)if(this.fc[(a+c+1)%this.Rg]&&!this.fc[(a+c+1)%this.Rg][2]){this.lg.children().eq((a+c+1)%this.Rg).find(".oj-train-label").focus();break}},getNodeBySubId:function(a){if(null===a)return this.element?this.element[0]:null;var c=a.index;if("number"!==typeof c||0>c||c>=this.Rg)return null;switch(a.subId){case "oj-train-step":return this.lg.children().eq(c)[0];case "oj-train-button":return this.lg.children().eq(c).find(".oj-train-button")[0];
case "oj-train-button-connector":return this.lg.children().eq(c).find(".oj-train-button-connector")[0];case "oj-train-connector":return this.D5;case "oj-train-connector-fill":return this.cS;case "oj-train-icon":return this.lg.children().eq(c).find(".oj-train-icon")[0];case "oj-train-label":return this.lg.children().eq(c).find(".oj-train-label")[0]}return null},getSubIdByNode:function(a){for(var c=this.fc?this.fc.length:0,d=0;d<c;d++){var e={subId:"oj-train-step",index:d};if(a===this.getNodeBySubId(e))return e}return null}})})();
a.Components.Xa("ojTrain","baseComponent",{properties:{selected:{},steps:{}},methods:{getStep:{},nextSelectableStep:{},previousSelectableStep:{},refresh:{},setStep:{}},extension:{_widgetName:"ojTrain"}});a.Components.register("oj-train",a.Components.getMetadata("ojTrain"))});