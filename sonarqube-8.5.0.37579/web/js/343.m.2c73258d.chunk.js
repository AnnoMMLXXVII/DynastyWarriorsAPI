(window.webpackJsonp=window.webpackJsonp||[]).push([[343],{1793:function(e,t,n){var r=n(313),a=n(1794);"string"==typeof(a=a.__esModule?a.default:a)&&(a=[[e.i,a,""]]);var l={insert:"head",singleton:!1},o=(r(a,l),a.locals?a.locals:{});e.exports=o},1794:function(e,t,n){(t=n(314)(!1)).push([e.i,".placeholder-bar{display:inline-block;vertical-align:middle;height:8px;background-color:currentColor}",""]),e.exports=t},1882:function(e,t,n){"use strict";n.r(t),n.d(t,"default",(function(){return _}));var r=n(2),a=n(316),l=n(329),o=n(31),c=n(343),s=n(6),i=n(323),m=n(413),d=n.n(m),u=n(351),h=n.n(u),p=n(1020);n(1793);function g({color:e,width:t,height:n}){return r.createElement("span",{className:"placeholder-bar",style:{color:e,width:t,height:n}})}var b=n(325);class E extends r.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={loading:!1},this.fetchProductNews=()=>{const{accessToken:e,tag:t}=this.props;e&&(this.setState({loading:!0}),Object(p.c)().then(({ref:n})=>Object(p.b)({accessToken:e,ref:n,tag:t})).then(e=>{this.mounted&&this.setState({news:e[0],loading:!1})},()=>{this.mounted&&this.setState({loading:!1})}))}}componentDidMount(){this.mounted=!0,this.fetchProductNews()}componentWillUnmount(){this.mounted=!1}renderPlaceholder(){return r.createElement("a",{className:"rich-item new-loading"},r.createElement("div",{className:"flex-1"},r.createElement("div",{className:"display-inline-flex-center"},r.createElement("h4",null,Object(o.translate)("embed_docs.latest_blog")),r.createElement("span",{className:"note spacer-left"},r.createElement(g,{color:"#aaa",width:60}))),r.createElement("p",{className:"little-spacer-bottom"},r.createElement(g,{color:"#aaa",width:84})," ",r.createElement(g,{color:"#aaa",width:48})," ",r.createElement(g,{color:"#aaa",width:24})," ",r.createElement(g,{color:"#aaa",width:72})," ",r.createElement(g,{color:"#aaa",width:24})," ",r.createElement(g,{color:"#aaa",width:48}))),r.createElement(d.a,{className:"flex-0"}))}render(){const{loading:e,news:t}=this.state;return e?this.renderPlaceholder():t?r.createElement("a",{className:"rich-item",href:"https://blog.sonarsource.com/"+t.uid,rel:"noopener noreferrer",target:"_blank"},r.createElement("div",{className:"flex-1"},r.createElement("div",{className:"display-inline-flex-center"},r.createElement("h4",null,Object(o.translate)("embed_docs.latest_blog")),r.createElement(h.a,{date:t.last_publication_date},e=>r.createElement("span",{className:"note spacer-left"},e))),r.createElement("p",{className:"little-spacer-bottom"},t.data.title)),r.createElement(d.a,{className:"flex-0"})):null}}var f=Object(i.connect)(e=>{const t=Object(b.getGlobalSettingValue)(e,"sonar.prismic.accessToken");return{accessToken:t&&t.value}})(E),w=n(368);class _ extends r.PureComponent{constructor(){super(...arguments),this.renderSuggestions=({suggestions:e})=>0===e.length?null:r.createElement(r.Fragment,null,this.renderTitle(Object(o.translate)("embed_docs.suggestion")),e.map((e,t)=>r.createElement("li",{key:t},r.createElement(a.Link,{onClick:this.props.onClose,target:"_blank",to:e.link},e.text))),r.createElement("li",{className:"divider"}))}renderTitle(e){return r.createElement("li",{className:"menu-header"},e)}renderIconLink(e,t,n){return r.createElement("a",{href:e,rel:"noopener noreferrer",target:"_blank"},r.createElement("img",{alt:n,className:"spacer-right",height:"18",src:"".concat(Object(c.getBaseUrl)(),"/images/").concat(t),width:"18"}),n)}renderSonarCloudLinks(){return r.createElement(r.Fragment,null,r.createElement("li",{className:"divider"}),r.createElement("li",null,r.createElement("a",{href:"https://community.sonarsource.com/c/help/sc",rel:"noopener noreferrer",target:"_blank"},Object(o.translate)("embed_docs.get_help"))),r.createElement("li",{className:"divider"}),this.renderTitle(Object(o.translate)("embed_docs.stay_connected")),r.createElement("li",null,this.renderIconLink("https://twitter.com/sonarcloud","embed-doc/twitter-icon.svg","Twitter")),r.createElement("li",null,this.renderIconLink("https://blog.sonarsource.com/product/SonarCloud","sonarcloud-square-logo.svg",Object(o.translate)("embed_docs.blog"))),r.createElement("li",null,r.createElement(f,{tag:"SonarCloud"})))}renderSonarQubeLinks(){return r.createElement(r.Fragment,null,r.createElement("li",{className:"divider"}),r.createElement("li",null,r.createElement("a",{href:"https://community.sonarsource.com/",rel:"noopener noreferrer",target:"_blank"},Object(o.translate)("embed_docs.get_help"))),r.createElement("li",{className:"divider"}),this.renderTitle(Object(o.translate)("embed_docs.stay_connected")),r.createElement("li",null,this.renderIconLink("https://www.sonarqube.org/whats-new/?referrer=sonarqube","embed-doc/sq-icon.svg",Object(o.translate)("embed_docs.news"))),r.createElement("li",null,this.renderIconLink("https://twitter.com/SonarQube","embed-doc/twitter-icon.svg","Twitter")))}render(){return r.createElement(l.DropdownOverlay,null,r.createElement("ul",{className:"menu abs-width-240"},r.createElement(w.a.Consumer,null,this.renderSuggestions),r.createElement("li",null,r.createElement(a.Link,{onClick:this.props.onClose,target:"_blank",to:"/documentation"},Object(o.translate)("embed_docs.documentation"))),r.createElement("li",null,r.createElement(a.Link,{onClick:this.props.onClose,to:"/web_api"},Object(o.translate)("api_documentation.page"))),Object(s.isSonarCloud)()?this.renderSonarCloudLinks():this.renderSonarQubeLinks()))}}},351:function(e,t,n){"use strict";var r=this&&this.__assign||function(){return(r=Object.assign||function(e){for(var t,n=1,r=arguments.length;n<r;n++)for(var a in t=arguments[n])Object.prototype.hasOwnProperty.call(t,a)&&(e[a]=t[a]);return e}).apply(this,arguments)};Object.defineProperty(t,"__esModule",{value:!0});var a=n(2),l=n(319),o=n(26);t.formatterOption={year:"numeric",month:"short",day:"2-digit"},t.longFormatterOption={year:"numeric",month:"long",day:"numeric"},t.default=function(e){var n=e.children,c=e.date,s=e.long;return a.createElement(l.FormattedDate,r({value:o.parseDate(c)},s?t.longFormatterOption:t.formatterOption),n)}}}]);
//# sourceMappingURL=343.m.2c73258d.chunk.js.map