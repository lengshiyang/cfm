(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[45],{b2ve:function(e,a,t){"use strict";t.r(a);t("ci4j");var n=t("xBlo"),r=(t("4Uu8"),t("FCXc")),s=(t("zdKM"),t("Xdy4")),l=(t("UwKw"),t("O+9C")),i=(t("hCod"),t("bSQV")),o=(t("hCuC"),t("m7+Q")),c=t("uqIC"),d=t.n(c),m=t("6xoq"),u=t("YR7N"),g=t("BS6i"),p=t.n(g),y=t("lVjH"),E=t.n(y),f=t("LOQS"),h=t("KTCi"),M=[{title:d.a.createElement(m["FormattedMessage"],{id:"app.analysis.table.rank",defaultMessage:"Rank"}),dataIndex:"index",key:"index"},{title:d.a.createElement(m["FormattedMessage"],{id:"app.analysis.table.search-keyword",defaultMessage:"Search keyword"}),dataIndex:"keyword",key:"keyword",render:function(e){return d.a.createElement("a",{href:"/"},e)}},{title:d.a.createElement(m["FormattedMessage"],{id:"app.analysis.table.users",defaultMessage:"Users"}),dataIndex:"count",key:"count",sorter:function(e,a){return e.count-a.count},className:E.a.alignRight},{title:d.a.createElement(m["FormattedMessage"],{id:"app.analysis.table.weekly-range",defaultMessage:"Weekly Range"}),dataIndex:"range",key:"range",sorter:function(e,a){return e.range-a.range},render:function(e,a){return d.a.createElement(u["a"],{flag:1===a.status?"down":"up"},d.a.createElement("span",{style:{marginRight:4}},e,"%"))},align:"right"}],w=Object(c["memo"])(function(e){var a=e.loading,t=e.visitData2,c=e.searchData,u=e.dropdownGroup;return d.a.createElement(n["a"],{loading:a,bordered:!1,title:d.a.createElement(m["FormattedMessage"],{id:"app.analysis.online-top-search",defaultMessage:"Online Top Search"}),extra:u,style:{marginTop:24}},d.a.createElement(s["a"],{gutter:68},d.a.createElement(l["a"],{sm:12,xs:24,style:{marginBottom:24}},d.a.createElement(f["a"],{subTitle:d.a.createElement("span",null,d.a.createElement(m["FormattedMessage"],{id:"app.analysis.search-users",defaultMessage:"search users"}),d.a.createElement(i["a"],{title:d.a.createElement(m["FormattedMessage"],{id:"app.analysis.introduce",defaultMessage:"introduce"})},d.a.createElement(o["a"],{style:{marginLeft:8},type:"info-circle-o"}))),gap:8,total:p()(12321).format("0,0"),status:"up",subTotal:17.1}),d.a.createElement(h["e"],{line:!0,height:45,data:t})),d.a.createElement(l["a"],{sm:12,xs:24,style:{marginBottom:24}},d.a.createElement(f["a"],{subTitle:d.a.createElement("span",null,d.a.createElement(m["FormattedMessage"],{id:"app.analysis.per-capita-search",defaultMessage:"Per Capita Search"}),d.a.createElement(i["a"],{title:d.a.createElement(m["FormattedMessage"],{id:"app.analysis.introduce",defaultMessage:"introduce"})},d.a.createElement(o["a"],{style:{marginLeft:8},type:"info-circle-o"}))),total:2.7,status:"down",subTotal:26.2,gap:8}),d.a.createElement(h["e"],{line:!0,height:45,data:t}))),d.a.createElement(r["a"],{rowKey:function(e){return e.index},size:"small",columns:M,dataSource:c,pagination:{style:{marginBottom:0},pageSize:5}}))});a["default"]=w}}]);