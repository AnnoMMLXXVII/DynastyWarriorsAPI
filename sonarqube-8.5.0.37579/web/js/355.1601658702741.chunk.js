(window.webpackJsonp=window.webpackJsonp||[]).push([[355],{1413:function(e,t,a){"use strict";a.r(t);var n,r=a(660),l=a(820),i=a(13),o=a(661),s=a(679),c=a.n(s),u=a(693),m=a.n(u),p=a(672),d=a(176),v=a(711),f=a(728),h=a(744),y=a(810),b=(n=function(e,t){return(n=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var a in t)t.hasOwnProperty(a)&&(e[a]=t[a])})(e,t)},function(e,t){function a(){this.constructor=e}n(e,t),e.prototype=null===t?Object.create(t):(a.prototype=t.prototype,new a)}),g=function(){return(g=Object.assign||function(e){for(var t,a=1,n=arguments.length;a<n;a++)for(var r in t=arguments[a])Object.prototype.hasOwnProperty.call(t,r)&&(e[r]=t[r]);return e}).apply(this,arguments)},E=function(e){function t(t){var a=e.call(this,t)||this;a.mounted=!1,a.getParams=function(e){var t=void 0===e?a.props:e,n=t.activation,r=t.rule,l={};if(r&&r.params){for(var i=0,o=r.params;i<o.length;i++){l[(u=o[i]).key]=u.defaultValue||""}if(n&&n.params)for(var s=0,c=n.params;s<c.length;s++){var u;l[(u=c[s]).key]=u.value}}return l},a.getQualityProfilesWithDepth=function(e){var t=(void 0===e?a.props:e).profiles;return Object(y.g)(t.filter((function(e){return!e.isBuiltIn&&e.actions&&e.actions.edit&&e.language===a.props.rule.lang}))).map((function(e){return g(g({},e),{depth:e.depth-1})}))},a.handleFormSubmit=function(e){e.preventDefault(),a.setState({submitting:!0});var t={key:a.state.profile,organization:a.props.organization,params:a.state.params,rule:a.props.rule.key,severity:a.state.severity};Object(v.a)(t).then((function(){return a.props.onDone(t.severity)})).then((function(){a.mounted&&(a.setState({submitting:!1}),a.props.onClose())}),(function(){a.mounted&&a.setState({submitting:!1})}))},a.handleParameterChange=function(e){var t=e.currentTarget,n=t.name,r=t.value;a.setState((function(e){var t;return{params:g(g({},e.params),(t={},t[n]=r,t))}}))},a.handleProfileChange=function(e){var t=e.value;a.setState({profile:t})},a.handleSeverityChange=function(e){var t=e.value;a.setState({severity:t})},a.renderSeverityOption=function(e){var t=e.value;return i.createElement(f.a,{severity:t})};var n=a.getQualityProfilesWithDepth(t);return a.state={params:a.getParams(t),profile:n.length>0?n[0].key:"",severity:t.activation?t.activation.severity:t.rule.severity,submitting:!1},a}return b(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this,t=this.props,a=t.activation,n=t.rule,s=this.state,u=s.profile,v=s.severity,f=s.submitting,y=n.params,b=void 0===y?[]:y,g=this.getQualityProfilesWithDepth(),E=!!n.templateKey,O=g.length<=0,_=!!a;return i.createElement(c.a,{contentLabel:this.props.modalHeader,onRequestClose:this.props.onClose,size:"small"},i.createElement("form",{onSubmit:this.handleFormSubmit},i.createElement("div",{className:"modal-head"},i.createElement("h2",null,this.props.modalHeader)),i.createElement("div",{className:r("modal-body",{"modal-container":b.length>0})},!_&&O&&i.createElement(p.Alert,{variant:"info"},Object(d.translate)("coding_rules.active_in_all_profiles")),i.createElement("div",{className:"modal-field"},i.createElement("label",null,Object(d.translate)("coding_rules.quality_profile")),i.createElement(m.a,{className:"js-profile",clearable:!1,disabled:f||1===g.length,onChange:this.handleProfileChange,options:g.map((function(e){return{label:"   ".repeat(e.depth)+e.name,value:e.key}})),value:u})),i.createElement("div",{className:"modal-field"},i.createElement("label",null,Object(d.translate)("severity")),i.createElement(m.a,{className:"js-severity",clearable:!1,disabled:f,onChange:this.handleSeverityChange,optionRenderer:this.renderSeverityOption,options:h.f.map((function(e){return{label:Object(d.translate)("severity",e),value:e}})),searchable:!1,value:v,valueRenderer:this.renderSeverityOption})),E?i.createElement("div",{className:"modal-field"},i.createElement("p",{className:"note"},Object(d.translate)("coding_rules.custom_rule.activation_notice"))):b.map((function(t){return i.createElement("div",{className:"modal-field",key:t.key},i.createElement("label",{title:t.key},t.key),"TEXT"===t.type?i.createElement("textarea",{disabled:f,name:t.key,onChange:e.handleParameterChange,placeholder:t.defaultValue,rows:3,value:e.state.params[t.key]||""}):i.createElement("input",{disabled:f,name:t.key,onChange:e.handleParameterChange,placeholder:t.defaultValue,type:"text",value:e.state.params[t.key]||""}),i.createElement("div",{className:"note",dangerouslySetInnerHTML:{__html:Object(l.sanitize)(t.htmlDesc||"")}}))}))),i.createElement("footer",{className:"modal-foot"},f&&i.createElement("i",{className:"spinner spacer-right"}),i.createElement(o.SubmitButton,{disabled:f||O},_?Object(d.translate)("save"):Object(d.translate)("coding_rules.activate")),i.createElement(o.ResetButtonLink,{disabled:f,onClick:this.props.onClose},Object(d.translate)("cancel")))))},t}(i.PureComponent);t.default=E},728:function(e,t,a){"use strict";a.d(t,"a",(function(){return o}));var n=a(13),r=a(795),l=a.n(r),i=a(176);function o(e){var t=e.className,a=e.severity;return a?n.createElement("span",{className:t},n.createElement(l.a,{className:"little-spacer-right",severity:a}),Object(i.translate)("severity",a)):null}}}]);
//# sourceMappingURL=355.1601658702741.chunk.js.map