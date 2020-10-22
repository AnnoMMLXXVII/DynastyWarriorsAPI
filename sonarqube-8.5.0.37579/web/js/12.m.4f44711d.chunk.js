(window.webpackJsonp=window.webpackJsonp||[]).push([[12],{1062:function(e,t,a){var s=a(313),l=a(1429);"string"==typeof(l=l.__esModule?l.default:l)&&(l=[[e.i,l,""]]);var i={insert:"head",singleton:!1},n=(s(l,i),l.locals?l.locals:{});e.exports=n},1063:function(e,t,a){"use strict";a.d(t,"a",(function(){return E}));var s=a(2),l=a(329),i=a.n(l),n=a(336),r=a.n(n),o=a(652),c=a.n(o),d=a(371),p=a.n(d),m=a(409),h=a.n(m),u=a(31),g=a(379);class E extends s.PureComponent{constructor(){super(...arguments),this.handleLanguageClick=e=>{e.preventDefault(),e.currentTarget.blur(),this.props.rule.lang&&this.props.onFilterChange({languages:[this.props.rule.lang]})},this.handleTypeClick=e=>{e.preventDefault(),e.currentTarget.blur(),this.props.onFilterChange({types:[this.props.rule.type]})},this.handleSeverityClick=e=>{e.preventDefault(),e.currentTarget.blur(),this.props.rule.severity&&this.props.onFilterChange({severities:[this.props.rule.severity]})},this.handleTagClick=e=>{e.preventDefault(),e.currentTarget.blur();const{tag:t}=e.currentTarget.dataset;t&&this.props.onFilterChange({tags:[t]})}}render(){const{rule:e}=this.props,{tags:t=[],sysTags:a=[],severity:l}=e,n=[...t,...a];return s.createElement(i.a,{className:"display-inline-block",overlay:s.createElement(s.Fragment,null,s.createElement("ul",{className:"menu"},s.createElement("li",{className:"menu-header"},Object(u.translate)("coding_rules.filter_similar_rules")),s.createElement("li",null,s.createElement("a",{"data-test":"coding-rules__similar-language",href:"#",onClick:this.handleLanguageClick},e.langName)),s.createElement("li",null,s.createElement("a",{className:"display-flex-center","data-test":"coding-rules__similar-type",href:"#",onClick:this.handleTypeClick},s.createElement(p.a,{query:e.type}),s.createElement("span",{className:"little-spacer-left"},Object(u.translate)("issue.type",e.type)))),l&&s.createElement("li",null,s.createElement("a",{"data-test":"coding-rules__similar-severity",href:"#",onClick:this.handleSeverityClick},s.createElement(g.a,{className:"display-flex-center",severity:e.severity}))),n.length>0&&s.createElement("li",{className:"divider"}),n.map(e=>s.createElement("li",{key:e},s.createElement("a",{"data-tag":e,"data-test":"coding-rules__similar-tag",href:"#",onClick:this.handleTagClick},s.createElement(h.a,{className:"icon-half-transparent little-spacer-right text-middle"}),s.createElement("span",{className:"text-middle"},e))))))},s.createElement("a",{className:"js-rule-filter link-no-underline spacer-left dropdown-toggle",href:"#",title:Object(u.translate)("coding_rules.filter_similar_rules")},s.createElement(c.a,{className:"icon-half-transparent"}),s.createElement(r.a,{className:"icon-half-transparent"})))}}},1155:function(e,t,a){"use strict";a.d(t,"a",(function(){return m}));var s=a(472),l=a(2),i=a(312),n=a(31),r=a(459),o=a(499),c=a(333),d=a.n(c);function p({onCancel:e,onSubmit:t}){const a=Object(n.translate)("coding_rules.remove_extended_description");return l.createElement(d.a,{header:a,onClose:e,onSubmit:t},({onCloseClick:e,onFormSubmit:t,submitting:s})=>l.createElement("form",{onSubmit:t},l.createElement("header",{className:"modal-head"},l.createElement("h2",null,a)),l.createElement("div",{className:"modal-body"},Object(n.translate)("coding_rules.remove_extended_description.confirm")),l.createElement("footer",{className:"modal-foot"},s&&l.createElement("i",{className:"spinner spacer-right"}),l.createElement(i.SubmitButton,{className:"button-red",disabled:s},Object(n.translate)("remove")),l.createElement(i.ResetButtonLink,{onClick:e},Object(n.translate)("cancel")))))}class m extends l.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={description:"",descriptionForm:!1,submitting:!1,removeDescriptionModal:!1},this.handleDescriptionChange=e=>this.setState({description:e.currentTarget.value}),this.handleCancelClick=()=>{this.setState({descriptionForm:!1})},this.handleSaveClick=()=>{this.updateDescription(this.state.description)},this.handleRemoveDescriptionClick=()=>{this.setState({removeDescriptionModal:!0})},this.handleCancelRemoving=()=>this.setState({removeDescriptionModal:!1}),this.handleConfirmRemoving=()=>{this.setState({removeDescriptionModal:!1}),this.updateDescription("")},this.updateDescription=e=>{this.setState({submitting:!0}),Object(r.h)({key:this.props.ruleDetails.key,markdown_note:e,organization:this.props.organization}).then(e=>{this.props.onChange(e),this.mounted&&this.setState({submitting:!1,descriptionForm:!1})},()=>{this.mounted&&this.setState({submitting:!1})})},this.handleExtendDescriptionClick=()=>{this.setState({description:this.props.ruleDetails.mdNote||"",descriptionForm:!0})},this.renderDescription=()=>l.createElement("div",{id:"coding-rules-detail-description-extra"},void 0!==this.props.ruleDetails.htmlNote&&l.createElement("div",{className:"rule-desc spacer-bottom markdown",dangerouslySetInnerHTML:{__html:Object(s.sanitize)(this.props.ruleDetails.htmlNote)}}),this.props.canWrite&&l.createElement(i.Button,{id:"coding-rules-detail-extend-description",onClick:this.handleExtendDescriptionClick},Object(n.translate)("coding_rules.extend_description"))),this.renderForm=()=>l.createElement("div",{className:"coding-rules-detail-extend-description-form"},l.createElement("table",{className:"width-100"},l.createElement("tbody",null,l.createElement("tr",null,l.createElement("td",{colSpan:2},l.createElement("textarea",{autoFocus:!0,className:"width-100 little-spacer-bottom",id:"coding-rules-detail-extend-description-text",onChange:this.handleDescriptionChange,rows:4,value:this.state.description}))),l.createElement("tr",null,l.createElement("td",null,l.createElement(i.Button,{disabled:this.state.submitting,id:"coding-rules-detail-extend-description-submit",onClick:this.handleSaveClick},Object(n.translate)("save")),void 0!==this.props.ruleDetails.mdNote&&l.createElement(l.Fragment,null,l.createElement(i.Button,{className:"button-red spacer-left",disabled:this.state.submitting,id:"coding-rules-detail-extend-description-remove",onClick:this.handleRemoveDescriptionClick},Object(n.translate)("remove")),this.state.removeDescriptionModal&&l.createElement(p,{onCancel:this.handleCancelRemoving,onSubmit:this.handleConfirmRemoving})),l.createElement(i.ResetButtonLink,{className:"spacer-left",disabled:this.state.submitting,id:"coding-rules-detail-extend-description-cancel",onClick:this.handleCancelClick},Object(n.translate)("cancel")),this.state.submitting&&l.createElement("i",{className:"spinner spacer-left"})),l.createElement("td",{className:"text-right"},l.createElement(o.a,null))))))}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const{ruleDetails:e}=this.props,t=!e.isExternal||"UNKNOWN"!==e.type;return l.createElement("div",{className:"js-rule-description"},t?l.createElement("div",{className:"coding-rules-detail-description rule-desc markdown",dangerouslySetInnerHTML:{__html:Object(s.sanitize)(e.htmlDesc||"")}}):l.createElement("div",{className:"coding-rules-detail-description rule-desc markdown"},Object(n.translateWithParameters)("issue.external_issue_description",e.name)),!e.templateKey&&l.createElement("div",{className:"coding-rules-detail-description coding-rules-detail-description-extra"},!this.state.descriptionForm&&this.renderDescription(),this.state.descriptionForm&&this.props.canWrite&&this.renderForm()))}}},1156:function(e,t,a){"use strict";a.d(t,"a",(function(){return z}));var s=a(2),l=a(316),i=a(312),n=a(329),r=a.n(n),o=a(324),c=a.n(o),d=a(318),p=a.n(d),m=a(371),h=a.n(m),u=a(498),g=a.n(u),E=a(351),v=a.n(E),x=a(370),f=a(31),y=a(379),b=a(497),N=a(321),S=a(360),C=a.n(S),k=a(412),w=a.n(k),_=a(388),O=a.n(_),j=a(459),D=a(550);class T extends s.PureComponent{constructor(){super(...arguments),this.mounted=!1,this.state={searchResult:[]},this.onSearch=e=>Object(j.d)({q:e,ps:Math.min(this.props.tags.length+10,100),organization:this.props.organization}).then(e=>{this.mounted&&this.setState({searchResult:C()(e,...this.props.sysTags)})},()=>{}),this.onSelect=e=>{this.props.setTags(w()([...this.props.tags,e]))},this.onUnselect=e=>{this.props.setTags(C()(this.props.tags,e))}}componentDidMount(){this.mounted=!0}componentWillUnmount(){this.mounted=!1}render(){const e=O()(this.state.searchResult,this.props.tags);return s.createElement(D.a,{listSize:10,onSearch:this.onSearch,onSelect:this.onSelect,onUnselect:this.onUnselect,selectedTags:this.props.tags,tags:e})}}var F=a(1063);class z extends s.PureComponent{constructor(){super(...arguments),this.renderType=()=>{const{ruleDetails:e}=this.props;return s.createElement(p.a,{overlay:Object(f.translate)("coding_rules.type.tooltip",e.type)},s.createElement("li",{className:"coding-rules-detail-property","data-meta":"type"},s.createElement(h.a,{className:"little-spacer-right",query:e.type}),Object(f.translate)("issue.type",e.type)))},this.renderSeverity=()=>s.createElement(p.a,{overlay:Object(f.translate)("default_severity")},s.createElement("li",{className:"coding-rules-detail-property","data-meta":"severity"},s.createElement(y.a,{className:"display-inline-flex-center",severity:this.props.ruleDetails.severity}))),this.renderStatus=()=>{const{ruleDetails:e}=this.props;return"READY"===e.status?null:s.createElement(p.a,{overlay:Object(f.translate)("status")},s.createElement("li",{className:"coding-rules-detail-property","data-meta":"status"},s.createElement("span",{className:"badge badge-error"},Object(f.translate)("rules.status",e.status))))},this.renderTags=()=>{const{canWrite:e,ruleDetails:t}=this.props,{sysTags:a=[],tags:l=[]}=t,n=[...a,...l];return s.createElement("li",{className:"coding-rules-detail-property","data-meta":"tags"},this.props.canWrite?s.createElement(r.a,{closeOnClick:!1,closeOnClickOutside:!0,overlay:s.createElement(T,{organization:this.props.organization,setTags:this.props.onTagsChange,sysTags:a,tags:l}),overlayPlacement:x.PopupPlacement.BottomLeft},s.createElement(i.ButtonLink,null,s.createElement(b.a,{allowUpdate:e,tags:n.length>0?n:[Object(f.translate)("coding_rules.no_tags")]}))):s.createElement(b.a,{allowUpdate:e,className:"display-flex-center",tags:n.length>0?n:[Object(f.translate)("coding_rules.no_tags")]}))},this.renderCreationDate=()=>s.createElement("li",{className:"coding-rules-detail-property","data-meta":"available-since"},s.createElement("span",{className:"little-spacer-right"},Object(f.translate)("coding_rules.available_since")),s.createElement(v.a,{date:this.props.ruleDetails.createdAt})),this.renderRepository=()=>{const{referencedRepositories:e,ruleDetails:t}=this.props,a=e[t.repo];return a?s.createElement(p.a,{overlay:Object(f.translate)("coding_rules.repository_language")},s.createElement("li",{className:"coding-rules-detail-property","data-meta":"repository"},a.name," (",t.langName,")")):null},this.renderTemplate=()=>this.props.ruleDetails.isTemplate?s.createElement(p.a,{overlay:Object(f.translate)("coding_rules.rule_template.title")},s.createElement("li",{className:"coding-rules-detail-property"},Object(f.translate)("coding_rules.rule_template"))):null,this.renderParentTemplate=()=>{const{ruleDetails:e}=this.props;return e.templateKey?s.createElement("li",{className:"coding-rules-detail-property"},Object(f.translate)("coding_rules.custom_rule")," (",s.createElement(l.Link,{to:Object(N.z)(e.templateKey,this.props.organization)},Object(f.translate)("coding_rules.show_template")),")",s.createElement(c.a,{className:"little-spacer-left",overlay:Object(f.translate)("coding_rules.custom_rule.help")})):null},this.renderRemediation=()=>{const{ruleDetails:e}=this.props;return e.debtRemFnType?s.createElement(p.a,{overlay:Object(f.translate)("coding_rules.remediation_function")},s.createElement("li",{className:"coding-rules-detail-property","data-meta":"remediation-function"},Object(f.translate)("coding_rules.remediation_function",e.debtRemFnType),":",void 0!==e.debtRemFnOffset&&" ".concat(e.debtRemFnOffset),void 0!==e.debtRemFnCoeff&&" +".concat(e.debtRemFnCoeff),void 0!==e.effortToFixDescription&&" ".concat(e.effortToFixDescription))):null},this.renderExternalBadge=()=>{const{ruleDetails:e}=this.props;if(!e.repo)return null;const t=e.repo.replace(new RegExp("^".concat("external_")),"");return t?s.createElement(p.a,{overlay:Object(f.translateWithParameters)("coding_rules.external_rule.engine",t)},s.createElement("li",{className:"coding-rules-detail-property"},s.createElement("div",{className:"badge spacer-left text-text-top"},t))):null}}renderKey(){const{ruleDetails:e}=this.props,t=e.key.startsWith("external_")?e.key.substr("external_".length):e.key;return s.createElement("span",{className:"note text-middle"},t)}render(){const{ruleDetails:e}=this.props,t=!e.isExternal||"UNKNOWN"!==e.type;return s.createElement("div",{className:"js-rule-meta"},s.createElement("header",{className:"page-header"},s.createElement("div",{className:"pull-right"},this.renderKey(),!e.isExternal&&s.createElement(l.Link,{className:"coding-rules-detail-permalink link-no-underline spacer-left text-middle",title:Object(f.translate)("permalink"),to:Object(N.z)(e.key,this.props.organization)},s.createElement(g.a,null)),!this.props.hideSimilarRulesFilter&&s.createElement(F.a,{onFilterChange:this.props.onFilterChange,rule:e})),s.createElement("h3",{className:"page-title coding-rules-detail-header"},s.createElement("big",null,e.name))),t&&s.createElement("ul",{className:"coding-rules-detail-properties"},this.renderType(),this.renderSeverity(),!e.isExternal&&this.renderStatus(),this.renderTags(),!e.isExternal&&this.renderCreationDate(),this.renderRepository(),!e.isExternal&&s.createElement(s.Fragment,null,this.renderTemplate(),this.renderParentTemplate(),this.renderRemediation()),e.isExternal&&this.renderExternalBadge()))}}},1429:function(e,t,a){(t=a(314)(!1)).push([e.i,".coding-rules-extended-view .coding-rules-list{display:none}.coding-rules-extended-view .coding-rules-details{display:block}.coding-rules-detail-title{position:relative;display:inline-block;margin:16px 0;font-size:16px;font-weight:400}.coding-rules-detail-quality-profile-parameter{display:block;height:100%;padding-top:0;padding-right:10px}.coding-rules-detail-quality-profile-parameter .key,.coding-rules-detail-quality-profile-parameter .sep,.coding-rules-detail-quality-profile-parameter .value{display:inline;vertical-align:top}.coding-rules-detail-quality-profile-parameter .value{display:inline-block;vertical-align:top;line-height:23px;max-width:300px;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;font-family:Consolas,Liberation Mono,Menlo,Courier,monospace}.coding-rules-detail-quality-profile-parameter+.coding-rules-detail-quality-profile-parameter{margin-top:0}.coding-rules-detail-properties{display:flex;flex-wrap:wrap;align-items:center;margin-top:8px}.coding-rules-detail-properties+.coding-rules-detail-properties{margin-top:-10px}.coding-rules-detail-property{display:flex;align-items:center;margin-right:16px;margin-bottom:8px;font-size:12px}.coding-rules-detail-tag+.coding-rules-detail-tag{margin-left:10px}.coding-rules-detail-tags-change{cursor:pointer}.coding-rules-detail-tags-change:hover span{text-decoration:underline}.coding-rules-detail-tag-edit{line-height:1}.coding-rules-details-tag-edit-cancel{vertical-align:middle}.coding-rules-detail-description{margin:20px 0}.coding-rules-detail-description-extra{margin-top:-10px}.coding-rules-detail-extend-description-form{margin:10px 0}.coding-rules-detail-parameters{width:100%;margin:10px 0 20px}.coding-rules-detail-parameter-name{width:1px;vertical-align:top;padding:5px 10px 5px 0;font-weight:700}.coding-rules-detail-parameter-description{vertical-align:top;padding:5px}.coding-rules-detail-parameter-value{font-family:Consolas,Liberation Mono,Menlo,Courier,monospace;word-break:break-all}.coding-rules-detail-list,.coding-rules-detail-quality-profiles{width:100%;line-height:22px}.coding-rules-detail-list td,.coding-rules-detail-quality-profiles td{border-top:1px solid #e6e6e6}.coding-rules-detail-list tr:first-child td,.coding-rules-detail-quality-profiles tr:first-child td{border-top:none}.coding-rules-detail-list-name,.coding-rules-detail-quality-profile-name{vertical-align:top;width:1px;padding:8px 5px 8px 0;font-weight:600;white-space:nowrap}.coding-rules-detail-list-severity,.coding-rules-detail-quality-profile-severity{vertical-align:top;width:1px;padding:8px 5px;white-space:nowrap}.coding-rules-detail-quality-profile-severity i{margin-top:2px}.coding-rules-detail-list-parameters,.coding-rules-detail-quality-profile-parameters{vertical-align:top;padding:8px 5px}.coding-rules-detail-list-actions,.coding-rules-detail-quality-profile-actions{vertical-align:top;width:1px;padding:8px 0 8px 5px;text-align:right;white-space:nowrap}.coding-rules-detail-quality-profile-inheritance{font-size:12px;font-weight:400}.coding-rules-detail-quality-profiles-activation{margin-top:-3px;margin-left:10px}.coding-rules-most-violated-projects td{border-top-color:transparent}.coding-rules-most-violated-projects tr:first-child+tr td{border-top-color:#e6e6e6}.coding-rules-most-violated-projects .coding-rules-detail-list-name{font-weight:400}.coding-rule{padding:8px 10px 8px 8px;border:1px solid transparent;background-color:#fff}.coding-rule.selected{border-color:#4b9fd5!important}.coding-rule+.coding-rule{border-top-color:#e6e6e6}.coding-rule.selected+.coding-rule{border-top-color:transparent}.coding-rule-table{width:100%}.coding-rule-table td{vertical-align:top}.coding-rule-table+.coding-rule-table{margin-top:5px}.coding-rule-table-meta-cell{width:1px;white-space:nowrap}@media (max-width:1320px){.coding-rule-table .tags-list span{max-width:100px}}.coding-rule-title{line-height:20px;font-size:13px}.coding-rule-meta{padding:2px 2px 2px 30px;font-size:12px}.coding-rule-activation{width:40px;line-height:19.5px}.coding-rule-activation-actions{padding-left:20px}.coding-rule-section-separator{height:0;margin:10px 0;border-top:1px solid #e6e6e6}",""]),e.exports=t},379:function(e,t,a){"use strict";a.d(t,"a",(function(){return r}));var s=a(2),l=a(447),i=a.n(l),n=a(31);function r({className:e,severity:t}){return t?s.createElement("span",{className:e},s.createElement(i.a,{className:"little-spacer-right",severity:t}),Object(n.translate)("severity",t)):null}},435:function(e,t,a){var s=a(313),l=a(511);"string"==typeof(l=l.__esModule?l.default:l)&&(l=[[e.i,l,""]]);var i={insert:"head",singleton:!1},n=(s(l,i),l.locals?l.locals:{});e.exports=n},487:function(e,t,a){"use strict";a.d(t,"a",(function(){return h}));var s=a(388),l=a.n(s),i=a(311),n=a(2),r=a(350),o=a.n(r),c=a(31),d=a(341),p=a.n(d);function m(e){const{active:t,custom:a,disabled:s,element:l,selected:r}=e,o=()=>e.onHover(l),d=i({active:t,disabled:s}),m=e.renderLabel(l);return n.createElement("li",{onFocus:o,onMouseOver:o},n.createElement(p.a,{checked:Boolean(r),className:d,disabled:s,id:l,onCheck:e.onSelectChange},a?n.createElement("span",{"aria-label":"".concat(Object(c.translate)("create_new_element"),": ").concat(m),className:"little-spacer-left"},n.createElement("span",{"aria-hidden":!0,className:"little-spacer-right"},"+"),m):n.createElement("span",{className:"little-spacer-left"},m)))}class h extends n.PureComponent{constructor(e){super(e),this.mounted=!1,this.handleSelectChange=(e,t)=>{e?this.onSelectItem(t):this.onUnselectItem(t)},this.handleSearchChange=e=>{this.onSearchQuery(this.props.validateSearchInput(e))},this.handleElementHover=e=>{this.setState((t,a)=>({activeIdx:this.getAllElements(a,t).indexOf(e)}))},this.handleKeyboard=e=>{switch(e.keyCode){case 40:e.stopPropagation(),e.preventDefault(),this.setState(this.selectNextElement);break;case 38:e.stopPropagation(),e.preventDefault(),this.setState(this.selectPreviousElement);break;case 37:case 39:e.stopPropagation();break;case 13:this.state.activeIdx>=0&&this.toggleSelect(this.getAllElements(this.props,this.state)[this.state.activeIdx])}},this.onSearchQuery=e=>{this.setState({activeIdx:0,loading:!0,query:e}),this.props.onSearch(e).then(this.stopLoading,this.stopLoading)},this.onSelectItem=e=>{this.isNewElement(e,this.props)&&this.onSearchQuery(""),this.props.onSelect(e)},this.onUnselectItem=e=>this.props.onUnselect(e),this.isNewElement=(e,{selectedElements:t,elements:a})=>e.length>0&&-1===t.indexOf(e)&&-1===a.indexOf(e),this.updateSelectedElements=e=>{this.setState(t=>t.query?{selectedElements:e.filterSelected(t.query,e.selectedElements)}:{selectedElements:[...e.selectedElements]})},this.updateUnselectedElements=e=>{this.setState(t=>0===e.listSize?{unselectedElements:l()(e.elements,e.selectedElements)}:e.listSize<t.selectedElements.length?{unselectedElements:[]}:{unselectedElements:l()(e.elements,e.selectedElements).slice(0,e.listSize-t.selectedElements.length)})},this.getAllElements=(e,t)=>this.isNewElement(t.query,e)?[...t.selectedElements,...t.unselectedElements,t.query]:[...t.selectedElements,...t.unselectedElements],this.setElementActive=e=>this.setState({activeIdx:e}),this.selectNextElement=(e,t)=>{const{activeIdx:a}=e,s=this.getAllElements(t,e);return a<0||a>=s.length-1?{activeIdx:0}:{activeIdx:a+1}},this.selectPreviousElement=(e,t)=>{const{activeIdx:a}=e,s=this.getAllElements(t,e);if(a<=0){return{activeIdx:s.length-1}}return{activeIdx:a-1}},this.stopLoading=()=>{this.mounted&&this.setState({loading:!1})},this.toggleSelect=e=>{-1===this.props.selectedElements.indexOf(e)?this.onSelectItem(e):this.onUnselectItem(e)},this.state={activeIdx:0,loading:!0,query:"",selectedElements:[],unselectedElements:[]}}componentDidMount(){this.mounted=!0,this.onSearchQuery(""),this.updateSelectedElements(this.props),this.updateUnselectedElements(this.props),this.container&&this.container.addEventListener("keydown",this.handleKeyboard,!0)}componentWillReceiveProps(e){if(this.props.elements!==e.elements||this.props.selectedElements!==e.selectedElements){this.updateSelectedElements(e),this.updateUnselectedElements(e);const t=this.getAllElements(e,this.state).length;this.state.activeIdx>=t&&this.setState({activeIdx:t-1})}}componentDidUpdate(){this.searchInput&&this.searchInput.focus()}componentWillUnmount(){this.mounted=!1,this.container&&this.container.removeEventListener("keydown",this.handleKeyboard)}render(){const{allowSelection:e=!0,allowNewElements:t=!0,footerNode:a=""}=this.props,{renderLabel:s}=this.props,{query:l,activeIdx:r,selectedElements:d,unselectedElements:p}=this.state,h=this.getAllElements(this.props,this.state)[r],u=t&&this.isNewElement(l,this.props),g=0===this.props.listSize,E=i("menu",{"menu-vertically-limited":g,"spacer-top":g,"with-top-separator":g,"with-bottom-separator":Boolean(a)});return n.createElement("div",{className:"multi-select",ref:e=>this.container=e},n.createElement("div",{className:"menu-search"},n.createElement(o.a,{autoFocus:!0,className:"little-spacer-top",loading:this.state.loading,onChange:this.handleSearchChange,placeholder:this.props.placeholder,value:l})),n.createElement("ul",{className:E},d.length>0&&d.map(e=>n.createElement(m,{active:h===e,element:e,key:e,onHover:this.handleElementHover,onSelectChange:this.handleSelectChange,renderLabel:s,selected:!0})),p.length>0&&p.map(t=>n.createElement(m,{active:h===t,disabled:!e,element:t,key:t,onHover:this.handleElementHover,onSelectChange:this.handleSelectChange,renderLabel:s})),u&&n.createElement(m,{active:h===l,custom:!0,element:l,key:l,onHover:this.handleElementHover,onSelectChange:this.handleSelectChange,renderLabel:s}),!u&&d.length<1&&p.length<1&&n.createElement("li",{className:"spacer-left"},Object(c.translateWithParameters)("no_results_for_x",l))),a)}}h.defaultProps={filterSelected:(e,t)=>t.filter(t=>t.includes(e)),listSize:0,renderLabel:e=>e,validateSearchInput:e=>e}},497:function(e,t,a){"use strict";a.d(t,"a",(function(){return d}));var s=a(311),l=a(2),i=a(336),n=a.n(i),r=a(409),o=a.n(r),c=a(31);a(435);function d({allowUpdate:e=!1,className:t,tags:a}){return l.createElement("span",{"aria-label":Object(c.translateWithParameters)("tags_list_x",a.join(", ")),className:s("tags-list",t)},l.createElement(o.a,{className:"text-middle"}),l.createElement("span",{"aria-hidden":!0,className:"text-ellipsis text-middle",title:a.join(", ")},a.join(", ")),e&&l.createElement(n.a,{className:"text-middle"}))}},499:function(e,t,a){"use strict";a.d(t,"a",(function(){return r}));var s=a(311),l=a(2),i=a(31),n=a(321);class r extends l.PureComponent{handleClick(e){e.preventDefault(),window.open(Object(n.o)(),"Markdown","height=300,width=600,scrollbars=1,resizable=1")}render(){return l.createElement("div",{className:s("markdown-tips",this.props.className)},l.createElement("a",{className:"little-spacer-right",href:"#",onClick:this.handleClick},Object(i.translate)("markdown.helplink")),":",l.createElement("span",{className:"spacer-left"},"*",Object(i.translate)("bold"),"*"),l.createElement("span",{className:"spacer-left"},"``",Object(i.translate)("code"),"``"),l.createElement("span",{className:"spacer-left"},"* ",Object(i.translate)("bulleted_point")))}}},511:function(e,t,a){(t=a(314)(!1)).push([e.i,".tags-list{white-space:nowrap;line-height:16px}.tags-list i:before{font-size:12px}.tags-list span{display:inline-block;vertical-align:middle;text-align:left;max-width:220px;padding-left:4px;padding-right:4px}",""]),e.exports=t},550:function(e,t,a){"use strict";a.d(t,"a",(function(){return n}));var s=a(2),l=a(31),i=a(487);a(435);function n(e){return s.createElement(i.a,{elements:e.tags,listSize:e.listSize,onSearch:e.onSearch,onSelect:e.onSelect,onUnselect:e.onUnselect,placeholder:Object(l.translate)("search.search_for_tags"),selectedElements:e.selectedTags,validateSearchInput:r})}function r(e){return e.toLowerCase().replace(/[^-a-z0-9+#.]/gi,"")}}}]);
//# sourceMappingURL=12.m.4f44711d.chunk.js.map