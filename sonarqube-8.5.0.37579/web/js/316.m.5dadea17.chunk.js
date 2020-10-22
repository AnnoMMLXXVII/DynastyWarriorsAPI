(window.webpackJsonp=window.webpackJsonp||[]).push([[316],{1874:function(e,t,n){"use strict";n.r(t),n.d(t,"Security",(function(){return f}));var o=n(2),r=n(332),a=n(323),s=n(31),i=n(325),l=n(312),c=n(322),u=n(445);class m extends o.Component{constructor(){super(...arguments),this.state={success:!1},this.handleSuccessfulChange=()=>{this.oldPassword.value="",this.password.value="",this.passwordConfirmation.value="",this.setState({success:!0,errors:void 0})},this.setErrors=e=>{this.setState({success:!1,errors:e})},this.handleChangePassword=e=>{e.preventDefault();const{user:t}=this.props,n=this.oldPassword.value,o=this.password.value;o!==this.passwordConfirmation.value?(this.password.focus(),this.setErrors([Object(s.translate)("user.password_doesnt_match_confirmation")])):Object(u.a)({login:t.login,password:o,previousPassword:n}).then(this.handleSuccessfulChange,()=>{})}}render(){const{success:e,errors:t}=this.state;return o.createElement("section",{className:"boxed-group"},o.createElement("h2",{className:"spacer-bottom"},Object(s.translate)("my_profile.password.title")),o.createElement("form",{className:"boxed-group-inner",onSubmit:this.handleChangePassword},e&&o.createElement(c.Alert,{variant:"success"},Object(s.translate)("my_profile.password.changed")),t&&t.map((e,t)=>o.createElement(c.Alert,{key:t,variant:"error"},e)),o.createElement("div",{className:"form-field"},o.createElement("label",{htmlFor:"old_password"},Object(s.translate)("my_profile.password.old"),o.createElement("em",{className:"mandatory"},"*")),o.createElement("input",{autoComplete:"off",id:"old_password",name:"old_password",ref:e=>this.oldPassword=e,required:!0,type:"password"})),o.createElement("div",{className:"form-field"},o.createElement("label",{htmlFor:"password"},Object(s.translate)("my_profile.password.new"),o.createElement("em",{className:"mandatory"},"*")),o.createElement("input",{autoComplete:"off",id:"password",name:"password",ref:e=>this.password=e,required:!0,type:"password"})),o.createElement("div",{className:"form-field"},o.createElement("label",{htmlFor:"password_confirmation"},Object(s.translate)("my_profile.password.confirm"),o.createElement("em",{className:"mandatory"},"*")),o.createElement("input",{autoComplete:"off",id:"password_confirmation",name:"password_confirmation",ref:e=>this.passwordConfirmation=e,required:!0,type:"password"})),o.createElement("div",{className:"form-field"},o.createElement(l.SubmitButton,{id:"change-password"},Object(s.translate)("my_profile.password.submit")))))}}var d=n(433),p=n(967);function h({login:e}){return o.createElement("div",{className:"boxed-group"},o.createElement("h2",null,Object(s.translate)("users.tokens")),o.createElement("div",{className:"boxed-group-inner"},o.createElement("div",{className:"big-spacer-bottom big-spacer-right markdown"},o.createElement(d.a,{message:Object(s.translate)("my_account.tokens_description")})),o.createElement(p.a,{deleteConfirmation:"modal",login:e})))}function f({user:e}){return o.createElement("div",{className:"account-body account-container"},o.createElement(r.a,{defer:!1,title:Object(s.translate)("my_account.security")}),o.createElement(h,{login:e.login}),e.local&&o.createElement(m,{user:e}))}t.default=Object(a.connect)(e=>({user:Object(i.getCurrentUser)(e)}))(f)},333:function(e,t,n){"use strict";var o,r=this&&this.__extends||(o=function(e,t){return(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}o(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),a=this&&this.__assign||function(){return(a=Object.assign||function(e){for(var t,n=1,o=arguments.length;n<o;n++)for(var r in t=arguments[n])Object.prototype.hasOwnProperty.call(t,r)&&(e[r]=t[r]);return e}).apply(this,arguments)},s=this&&this.__rest||function(e,t){var n={};for(var o in e)Object.prototype.hasOwnProperty.call(e,o)&&t.indexOf(o)<0&&(n[o]=e[o]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var r=0;for(o=Object.getOwnPropertySymbols(e);r<o.length;r++)t.indexOf(o[r])<0&&Object.prototype.propertyIsEnumerable.call(e,o[r])&&(n[o[r]]=e[o[r]])}return n};Object.defineProperty(t,"__esModule",{value:!0});var i=n(2),l=n(330),c=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={submitting:!1},t.stopSubmitting=function(){t.mounted&&t.setState({submitting:!1})},t.handleCloseClick=function(e){e&&(e.preventDefault(),e.currentTarget.blur()),t.props.onClose()},t.handleFormSubmit=function(e){e.preventDefault(),t.submit()},t.handleSubmitClick=function(e){e&&(e.preventDefault(),e.currentTarget.blur()),t.submit()},t.submit=function(){var e=t.props.onSubmit();e&&(t.setState({submitting:!0}),e.then(t.stopSubmitting,t.stopSubmitting))},t}return r(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this.props,t=e.children,n=e.header,o=e.onClose,r=(e.onSubmit,s(e,["children","header","onClose","onSubmit"]));return i.createElement(l.default,a({contentLabel:n,onRequestClose:o},r),t({onCloseClick:this.handleCloseClick,onFormSubmit:this.handleFormSubmit,onSubmitClick:this.handleSubmitClick,submitting:this.state.submitting}))},t}(i.Component);t.default=c},349:function(e,t,n){"use strict";var o,r=this&&this.__extends||(o=function(e,t){return(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}o(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),a=this&&this.__assign||function(){return(a=Object.assign||function(e){for(var t,n=1,o=arguments.length;n<o;n++)for(var r in t=arguments[n])Object.prototype.hasOwnProperty.call(t,r)&&(e[r]=t[r]);return e}).apply(this,arguments)};Object.defineProperty(t,"__esModule",{value:!0});var s=n(2),i=n(31),l=n(317),c=n(312),u=n(422),m=n(333),d=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.handleSubmit=function(){var e=t.props.onConfirm(t.props.confirmData);return e?e.then(t.props.onClose,(function(){})):void t.props.onClose()},t.renderModalContent=function(e){var n=e.onCloseClick,o=e.onFormSubmit,r=e.submitting,a=t.props,m=a.children,d=a.confirmButtonText,p=a.confirmDisable,h=a.header,f=a.headerDescription,b=a.isDestructive,g=a.cancelButtonText,v=void 0===g?i.translate("cancel"):g;return s.createElement(u.default,null,s.createElement("form",{onSubmit:o},s.createElement("header",{className:"modal-head"},s.createElement("h2",null,h),f),s.createElement("div",{className:"modal-body"},m),s.createElement("footer",{className:"modal-foot"},s.createElement(l.default,{className:"spacer-right",loading:r}),s.createElement(c.SubmitButton,{autoFocus:!0,className:b?"button-red":void 0,disabled:r||p},d),s.createElement(c.ResetButtonLink,{disabled:r,onClick:n},v))))},t}return r(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){var e=this.props,t={header:e.header,onClose:e.onClose,noBackdrop:e.noBackdrop,size:e.size};return s.createElement(m.default,a({onSubmit:this.handleSubmit},t),this.renderModalContent)},t}(s.PureComponent);t.default=d},351:function(e,t,n){"use strict";var o=this&&this.__assign||function(){return(o=Object.assign||function(e){for(var t,n=1,o=arguments.length;n<o;n++)for(var r in t=arguments[n])Object.prototype.hasOwnProperty.call(t,r)&&(e[r]=t[r]);return e}).apply(this,arguments)};Object.defineProperty(t,"__esModule",{value:!0});var r=n(2),a=n(319),s=n(26);t.formatterOption={year:"numeric",month:"short",day:"2-digit"},t.longFormatterOption={year:"numeric",month:"long",day:"numeric"},t.default=function(e){var n=e.children,i=e.date,l=e.long;return r.createElement(a.FormattedDate,o({value:s.parseDate(i)},l?t.longFormatterOption:t.formatterOption),n)}},359:function(e,t,n){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var o=n(449),r=n(2),a=n(319),s=n(26),i=n(31),l=n(357);t.default=function(e){var t=e.children,n=void 0===t?function(e){return e}:t,c=e.date,u=e.hourPrecision,m=n;if(!c)return r.createElement(r.Fragment,null,n(i.translate("never")));c&&u&&o.differenceInHours(Date.now(),c)<1&&(m=function(){return n(i.translate("less_than_1_hour_ago"))});var d=s.parseDate(c);return r.createElement(l.default,{date:d},(function(e){return r.createElement("span",{title:e},r.createElement(a.FormattedRelative,{value:d},m))}))}},380:function(e,t,n){"use strict";var o,r=this&&this.__extends||(o=function(e,t){return(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}o(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)}),a=this&&this.__assign||function(){return(a=Object.assign||function(e){for(var t,n=1,o=arguments.length;n<o;n++)for(var r in t=arguments[n])Object.prototype.hasOwnProperty.call(t,r)&&(e[r]=t[r]);return e}).apply(this,arguments)},s=this&&this.__rest||function(e,t){var n={};for(var o in e)Object.prototype.hasOwnProperty.call(e,o)&&t.indexOf(o)<0&&(n[o]=e[o]);if(null!=e&&"function"==typeof Object.getOwnPropertySymbols){var r=0;for(o=Object.getOwnPropertySymbols(e);r<o.length;r++)t.indexOf(o[r])<0&&Object.prototype.propertyIsEnumerable.call(e,o[r])&&(n[o[r]]=e[o[r]])}return n};Object.defineProperty(t,"__esModule",{value:!0});var i=n(2),l=n(349),c=n(381),u=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.renderConfirmModal=function(e){var n=e.onClose,o=t.props,r=(o.children,o.modalBody),c=o.modalHeader,u=o.modalHeaderDescription,m=s(o,["children","modalBody","modalHeader","modalHeaderDescription"]);return i.createElement(l.default,a({header:c,headerDescription:u,onClose:n},m),r)},t}return r(t,e),t.prototype.render=function(){return i.createElement(c.default,{modal:this.renderConfirmModal},this.props.children)},t}(i.PureComponent);t.default=u},381:function(e,t,n){"use strict";var o,r=this&&this.__extends||(o=function(e,t){return(o=Object.setPrototypeOf||{__proto__:[]}instanceof Array&&function(e,t){e.__proto__=t}||function(e,t){for(var n in t)t.hasOwnProperty(n)&&(e[n]=t[n])})(e,t)},function(e,t){function n(){this.constructor=e}o(e,t),e.prototype=null===t?Object.create(t):(n.prototype=t.prototype,new n)});Object.defineProperty(t,"__esModule",{value:!0});var a=n(2),s=function(e){function t(){var t=null!==e&&e.apply(this,arguments)||this;return t.mounted=!1,t.state={modal:!1},t.handleButtonClick=function(){t.setState({modal:!0})},t.handleFormSubmit=function(e){e&&e.preventDefault(),t.setState({modal:!0})},t.handleCloseModal=function(){t.mounted&&t.setState({modal:!1})},t}return r(t,e),t.prototype.componentDidMount=function(){this.mounted=!0},t.prototype.componentWillUnmount=function(){this.mounted=!1},t.prototype.render=function(){return a.createElement(a.Fragment,null,this.props.children({onClick:this.handleButtonClick,onFormSubmit:this.handleFormSubmit}),this.state.modal&&this.props.modal({onClose:this.handleCloseModal}))},t}(a.PureComponent);t.default=s},578:function(e,t,n){"use strict";n.d(t,"b",(function(){return a})),n.d(t,"a",(function(){return s})),n.d(t,"c",(function(){return i}));var o=n(9),r=n(326);function a(e){return Object(o.getJSON)("/api/user_tokens/search",{login:e}).then(e=>e.userTokens,r.a)}function s(e){return Object(o.postJSON)("/api/user_tokens/generate",e).catch(r.a)}function i(e){return Object(o.post)("/api/user_tokens/revoke",e).catch(r.a)}},967:function(e,t,n){"use strict";n.d(t,"a",(function(){return O}));var o=n(2),r=n(312),a=n(317),s=n.n(a),i=n(31),l=n(578),c=n(319),u=n(380),m=n.n(u),d=n(318),p=n.n(d),h=n(351),f=n.n(h),b=n(359),g=n.n(b),v=n(391);class y extends o.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!1,showConfirmation:!1},this.handleClick=()=>{this.state.showConfirmation?this.handleRevoke().then(()=>{this.mounted&&this.setState({showConfirmation:!1})}):this.setState({showConfirmation:!0})},this.handleRevoke=()=>(this.setState({loading:!0}),Object(l.c)({login:this.props.login,name:this.props.token.name}).then(()=>this.props.onRevokeToken(this.props.token),()=>{this.mounted&&this.setState({loading:!1})}))}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const{deleteConfirmation:e,token:t}=this.props,{loading:n,showConfirmation:a}=this.state;return o.createElement("tr",null,o.createElement("td",null,o.createElement(p.a,{overlay:t.name},o.createElement("span",null,Object(v.limitComponentName)(t.name)))),o.createElement("td",{className:"nowrap"},o.createElement(g.a,{date:t.lastConnectionDate,hourPrecision:!0})),o.createElement("td",{className:"thin nowrap text-right"},o.createElement(f.a,{date:t.createdAt,long:!0})),o.createElement("td",{className:"thin nowrap text-right"},o.createElement(s.a,{loading:n},o.createElement("i",{className:"deferred-spinner-placeholder"})),"modal"===e?o.createElement(m.a,{confirmButtonText:Object(i.translate)("users.tokens.revoke_token"),isDestructive:!0,modalBody:o.createElement(c.FormattedMessage,{defaultMessage:Object(i.translate)("users.tokens.sure_X"),id:"users.tokens.sure_X",values:{token:o.createElement("strong",null,t.name)}}),modalHeader:Object(i.translate)("users.tokens.revoke_token"),onConfirm:this.handleRevoke},({onClick:e})=>o.createElement(r.Button,{className:"spacer-left button-red input-small",disabled:n,onClick:e,title:Object(i.translate)("users.tokens.revoke_token")},Object(i.translate)("users.tokens.revoke"))):o.createElement(r.Button,{className:"button-red input-small spacer-left",disabled:n,onClick:this.handleClick},a?Object(i.translate)("users.tokens.sure"):Object(i.translate)("users.tokens.revoke"))))}}var k=n(369),_=n(322);function E({token:e}){return o.createElement("div",{className:"panel panel-white big-spacer-top"},o.createElement(_.Alert,{variant:"warning"},Object(i.translateWithParameters)("users.tokens.new_token_created",e.name)),o.createElement(k.ClipboardButton,{copyValue:e.token}),o.createElement("code",{className:"big-spacer-left text-success"},e.token))}class O extends o.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={generating:!1,loading:!0,newTokenName:"",tokens:[]},this.fetchTokens=()=>{this.setState({loading:!0}),Object(l.b)(this.props.login).then(e=>{this.mounted&&this.setState({loading:!1,tokens:e})},()=>{this.mounted&&this.setState({loading:!1})})},this.updateTokensCount=()=>{this.props.updateTokensCount&&this.props.updateTokensCount(this.props.login,this.state.tokens.length)},this.handleGenerateToken=e=>{e.preventDefault(),this.state.newTokenName.length>0&&(this.setState({generating:!0}),Object(l.a)({name:this.state.newTokenName,login:this.props.login}).then(e=>{this.mounted&&this.setState(t=>{const n=[...t.tokens,{name:e.name,createdAt:e.createdAt}];return{generating:!1,newToken:e,newTokenName:"",tokens:n}},this.updateTokensCount)},()=>{this.mounted&&this.setState({generating:!1})}))},this.handleRevokeToken=e=>{this.setState(t=>({tokens:t.tokens.filter(t=>t.name!==e.name)}),this.updateTokensCount)},this.handleNewTokenChange=e=>this.setState({newTokenName:e.currentTarget.value})}componentDidMount(){this.mounted=!0,this.fetchTokens()}componentWillUnmount(){this.mounted=!1}renderItems(){const{tokens:e}=this.state;return e.length<=0?o.createElement("tr",null,o.createElement("td",{className:"note",colSpan:3},Object(i.translate)("users.no_tokens"))):e.map(e=>o.createElement(y,{deleteConfirmation:this.props.deleteConfirmation,key:e.name,login:this.props.login,onRevokeToken:this.handleRevokeToken,token:e}))}render(){const{generating:e,loading:t,newToken:n,newTokenName:a,tokens:l}=this.state,c=o.createElement("tr",null,o.createElement("td",null,o.createElement("i",{className:"spinner"})));return o.createElement(o.Fragment,null,o.createElement("h3",{className:"spacer-bottom"},Object(i.translate)("users.generate_tokens")),o.createElement("form",{autoComplete:"off",className:"display-flex-center",id:"generate-token-form",onSubmit:this.handleGenerateToken},o.createElement("input",{className:"input-large spacer-right",maxLength:100,onChange:this.handleNewTokenChange,placeholder:Object(i.translate)("users.enter_token_name"),required:!0,type:"text",value:a}),o.createElement(r.SubmitButton,{className:"js-generate-token",disabled:e||a.length<=0},Object(i.translate)("users.generate"))),n&&o.createElement(E,{token:n}),o.createElement("table",{className:"data zebra big-spacer-top"},o.createElement("thead",null,o.createElement("tr",null,o.createElement("th",null,Object(i.translate)("name")),o.createElement("th",null,Object(i.translate)("my_account.tokens_last_usage")),o.createElement("th",{className:"text-right"},Object(i.translate)("created")),o.createElement("th",null))),o.createElement("tbody",null,o.createElement(s.a,{customSpinner:c,loading:t&&l.length<=0},this.renderItems()))))}}}}]);
//# sourceMappingURL=316.m.5dadea17.chunk.js.map