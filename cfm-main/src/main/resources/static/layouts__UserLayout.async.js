(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[3],{BOD2:function(e,a,t){e.exports={container:"antd-pro-layouts-user-layout-container",lang:"antd-pro-layouts-user-layout-lang",content:"antd-pro-layouts-user-layout-content",top:"antd-pro-layouts-user-layout-top",header:"antd-pro-layouts-user-layout-header",logo:"antd-pro-layouts-user-layout-logo",title:"antd-pro-layouts-user-layout-title",desc:"antd-pro-layouts-user-layout-desc"}},jH8a:function(e,a,t){"use strict";t.r(a);var n=t("Pjwa"),r=t.n(n),o=t("2cji"),l=t.n(o),s=t("sp3j"),u=t.n(s),c=t("vZkh"),i=t.n(c),m=t("+KCP"),p=t.n(m),y=(t("hCuC"),t("m7+Q")),d=t("uqIC"),h=t.n(d),g=t("6xoq"),f=t("LneV"),v=t("uUPy"),b=t("ggcP"),E=t("Cjad"),k=t.n(E),N=t("bfXr"),j=t("BOD2"),C=t.n(j),M=t("mxmt"),w=t.n(M),O=t("tGQQ"),D=[{key:"help",title:Object(g["formatMessage"])({id:"layout.user.link.help"}),href:""},{key:"privacy",title:Object(g["formatMessage"])({id:"layout.user.link.privacy"}),href:""},{key:"terms",title:Object(g["formatMessage"])({id:"layout.user.link.terms"}),href:""}],P=h.a.createElement(d["Fragment"],null,"Copyright ",h.a.createElement(y["a"],{type:"copyright"})," 2019 TaiChi \u6280\u672f\u90e8"),x=function(e){function a(){return r()(this,a),u()(this,i()(a).apply(this,arguments))}return p()(a,e),l()(a,[{key:"componentDidMount",value:function(){var e=this.props,a=e.dispatch,t=e.route,n=t.routes,r=t.authority;a({type:"menu/getMenuData",payload:{routes:n,authority:r}})}},{key:"render",value:function(){var e=this.props,a=e.children,t=e.location.pathname,n=e.breadcrumbNameMap;return h.a.createElement(k.a,{title:Object(O["a"])(t,n)},h.a.createElement("div",{className:C.a.container},h.a.createElement("div",{className:C.a.lang},h.a.createElement(N["a"],null)),h.a.createElement("div",{className:C.a.content},h.a.createElement("div",{className:C.a.top},h.a.createElement("div",{className:C.a.header},h.a.createElement(v["a"],{to:"/"},h.a.createElement("img",{alt:"logo",className:C.a.logo,src:w.a}),h.a.createElement("span",{className:C.a.title},"taichi cfm"))),h.a.createElement("div",{className:C.a.desc},"\u7edf\u4e00\u7ba1\u7406\u540e\u53f0")),a),h.a.createElement(b["a"],{links:D,copyright:P})))}}]),a}(d["Component"]);a["default"]=Object(f["connect"])(function(e){var a=e.menu;return{menuData:a.menuData,breadcrumbNameMap:a.breadcrumbNameMap}})(x)}}]);