(window.webpackJsonp=window.webpackJsonp||[]).push([[329],{1881:function(t,e,n){"use strict";n.r(e),n.d(e,"default",(function(){return b}));var o=n(2),r=n(332),i=n(31),a=n(312),c=n(380),l=n.n(c),s=n(365),u=n(437),p=n(364),d=n(337);class m extends o.PureComponent{constructor(){super(...arguments),this.handleDelete=async()=>{const{component:t}=this.props,e=t.qualifier===d.a.Project?s.e:s.d,n=Object(d.c)(t.qualifier)?"/portfolios":"/";await e(t.key),Object(u.a)(Object(i.translateWithParameters)("project_deletion.resource_deleted",t.name)),this.props.router.replace(n)}}render(){const{component:t}=this.props;return o.createElement(l.a,{confirmButtonText:Object(i.translate)("delete"),isDestructive:!0,modalBody:Object(i.translateWithParameters)("project_deletion.delete_resource_confirmation",t.name),modalHeader:Object(i.translate)("qualifier.delete",t.qualifier),onConfirm:this.handleDelete},({onClick:t})=>o.createElement(a.Button,{className:"button-red",id:"delete-project",onClick:t},Object(i.translate)("delete")))}}var f=Object(p.a)(m);function h(t){const{qualifier:e}=t.component;let n;return n=["VW","SVW"].includes(e)?Object(i.translate)("portfolio_deletion.page.description"):"APP"===e?Object(i.translate)("application_deletion.page.description"):Object(i.translate)("project_deletion.page.description"),o.createElement("header",{className:"page-header"},o.createElement("h1",{className:"page-title"},Object(i.translate)("deletion.page")),o.createElement("div",{className:"page-description"},n))}function b(t){return o.createElement("div",{className:"page page-limited"},o.createElement(r.a,{defer:!1,title:Object(i.translate)("deletion.page")}),o.createElement(h,{component:t.component}),o.createElement(f,{component:t.component}))}},333:function(t,e,n){"use strict";var o,r=this&&this.__extends||(o=function(t,e){return(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}o(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),i=this&&this.__assign||function(){return(i=Object.assign||function(t){for(var e,n=1,o=arguments.length;n<o;n++)for(var r in e=arguments[n])Object.prototype.hasOwnProperty.call(e,r)&&(t[r]=e[r]);return t}).apply(this,arguments)},a=this&&this.__rest||function(t,e){var n={};for(var o in t)Object.prototype.hasOwnProperty.call(t,o)&&e.indexOf(o)<0&&(n[o]=t[o]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var r=0;for(o=Object.getOwnPropertySymbols(t);r<o.length;r++)e.indexOf(o[r])<0&&Object.prototype.propertyIsEnumerable.call(t,o[r])&&(n[o[r]]=t[o[r]])}return n};Object.defineProperty(e,"__esModule",{value:!0});var c=n(2),l=n(330),s=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.state={submitting:!1},e.stopSubmitting=function(){e.mounted&&e.setState({submitting:!1})},e.handleCloseClick=function(t){t&&(t.preventDefault(),t.currentTarget.blur()),e.props.onClose()},e.handleFormSubmit=function(t){t.preventDefault(),e.submit()},e.handleSubmitClick=function(t){t&&(t.preventDefault(),t.currentTarget.blur()),e.submit()},e.submit=function(){var t=e.props.onSubmit();t&&(e.setState({submitting:!0}),t.then(e.stopSubmitting,e.stopSubmitting))},e}return r(e,t),e.prototype.componentDidMount=function(){this.mounted=!0},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.render=function(){var t=this.props,e=t.children,n=t.header,o=t.onClose,r=(t.onSubmit,a(t,["children","header","onClose","onSubmit"]));return c.createElement(l.default,i({contentLabel:n,onRequestClose:o},r),e({onCloseClick:this.handleCloseClick,onFormSubmit:this.handleFormSubmit,onSubmitClick:this.handleSubmitClick,submitting:this.state.submitting}))},e}(c.Component);e.default=s},349:function(t,e,n){"use strict";var o,r=this&&this.__extends||(o=function(t,e){return(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}o(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),i=this&&this.__assign||function(){return(i=Object.assign||function(t){for(var e,n=1,o=arguments.length;n<o;n++)for(var r in e=arguments[n])Object.prototype.hasOwnProperty.call(e,r)&&(t[r]=e[r]);return t}).apply(this,arguments)};Object.defineProperty(e,"__esModule",{value:!0});var a=n(2),c=n(31),l=n(317),s=n(312),u=n(422),p=n(333),d=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.handleSubmit=function(){var t=e.props.onConfirm(e.props.confirmData);return t?t.then(e.props.onClose,(function(){})):void e.props.onClose()},e.renderModalContent=function(t){var n=t.onCloseClick,o=t.onFormSubmit,r=t.submitting,i=e.props,p=i.children,d=i.confirmButtonText,m=i.confirmDisable,f=i.header,h=i.headerDescription,b=i.isDestructive,y=i.cancelButtonText,_=void 0===y?c.translate("cancel"):y;return a.createElement(u.default,null,a.createElement("form",{onSubmit:o},a.createElement("header",{className:"modal-head"},a.createElement("h2",null,f),h),a.createElement("div",{className:"modal-body"},p),a.createElement("footer",{className:"modal-foot"},a.createElement(l.default,{className:"spacer-right",loading:r}),a.createElement(s.SubmitButton,{autoFocus:!0,className:b?"button-red":void 0,disabled:r||m},d),a.createElement(s.ResetButtonLink,{disabled:r,onClick:n},_))))},e}return r(e,t),e.prototype.componentDidMount=function(){this.mounted=!0},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.render=function(){var t=this.props,e={header:t.header,onClose:t.onClose,noBackdrop:t.noBackdrop,size:t.size};return a.createElement(p.default,i({onSubmit:this.handleSubmit},e),this.renderModalContent)},e}(a.PureComponent);e.default=d},380:function(t,e,n){"use strict";var o,r=this&&this.__extends||(o=function(t,e){return(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}o(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)}),i=this&&this.__assign||function(){return(i=Object.assign||function(t){for(var e,n=1,o=arguments.length;n<o;n++)for(var r in e=arguments[n])Object.prototype.hasOwnProperty.call(e,r)&&(t[r]=e[r]);return t}).apply(this,arguments)},a=this&&this.__rest||function(t,e){var n={};for(var o in t)Object.prototype.hasOwnProperty.call(t,o)&&e.indexOf(o)<0&&(n[o]=t[o]);if(null!=t&&"function"==typeof Object.getOwnPropertySymbols){var r=0;for(o=Object.getOwnPropertySymbols(t);r<o.length;r++)e.indexOf(o[r])<0&&Object.prototype.propertyIsEnumerable.call(t,o[r])&&(n[o[r]]=t[o[r]])}return n};Object.defineProperty(e,"__esModule",{value:!0});var c=n(2),l=n(349),s=n(381),u=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.renderConfirmModal=function(t){var n=t.onClose,o=e.props,r=(o.children,o.modalBody),s=o.modalHeader,u=o.modalHeaderDescription,p=a(o,["children","modalBody","modalHeader","modalHeaderDescription"]);return c.createElement(l.default,i({header:s,headerDescription:u,onClose:n},p),r)},e}return r(e,t),e.prototype.render=function(){return c.createElement(s.default,{modal:this.renderConfirmModal},this.props.children)},e}(c.PureComponent);e.default=u},381:function(t,e,n){"use strict";var o,r=this&&this.__extends||(o=function(t,e){return(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(t,e){t.__proto__=e}||function(t,e){for(var n in e)e.hasOwnProperty(n)&&(t[n]=e[n])})(t,e)},function(t,e){function n(){this.constructor=t}o(t,e),t.prototype=null===e?Object.create(e):(n.prototype=e.prototype,new n)});Object.defineProperty(e,"__esModule",{value:!0});var i=n(2),a=function(t){function e(){var e=null!==t&&t.apply(this,arguments)||this;return e.mounted=!1,e.state={modal:!1},e.handleButtonClick=function(){e.setState({modal:!0})},e.handleFormSubmit=function(t){t&&t.preventDefault(),e.setState({modal:!0})},e.handleCloseModal=function(){e.mounted&&e.setState({modal:!1})},e}return r(e,t),e.prototype.componentDidMount=function(){this.mounted=!0},e.prototype.componentWillUnmount=function(){this.mounted=!1},e.prototype.render=function(){return i.createElement(i.Fragment,null,this.props.children({onClick:this.handleButtonClick,onFormSubmit:this.handleFormSubmit}),this.state.modal&&this.props.modal({onClose:this.handleCloseModal}))},e}(i.PureComponent);e.default=a},437:function(t,e,n){"use strict";n.d(e,"a",(function(){return i}));var o=n(394),r=n(393);function i(t){Object(r.default)().dispatch(o.b(t))}}}]);
//# sourceMappingURL=329.m.005ca32f.chunk.js.map