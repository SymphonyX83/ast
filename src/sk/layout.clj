(ns sk.layout
  (:require [clj-time.core :as t]
            [hiccup.page :refer [html5 include-css include-js]]
            [sk.models.util :refer [user-level user-name]]
            [sk.migrations :refer [config]]))

(defn build-admin []
  (list
   [:a.dropdown-item {:href "/admin/ft_clasificacion"} "Clasificacion (Ficha Técnica)"]
   [:a.dropdown-item {:href "/admin/dictamen_ce"} "Condiciones del Equipo (Dictamen)"]
   [:a.dropdown-item {:href "/admin/equipos"} "Equipos"]
   [:a.dropdown-item {:href "/admin/dictamen_end"} "Examenes no Destructivos (Dictamen)"]
   [:a.dropdown-item {:href "/admin/hermeticidad"} "Hermeticidad"]
   [:a.dropdown-item {:href "/admin/lp"} "Lugares de Prueba"]
   [:a.dropdown-item {:href "/admin/mfe"} "Materiales de Fabricacion de Envolventes"]
   [:a.dropdown-item {:href "/admin/mfes"} "Materiales de Fabricacion de Espejos"]
   [:a.dropdown-item {:href "/admin/mft1"} "Materiales de Fabricacion de Tapas (Hogar)"]
   [:a.dropdown-item {:href "/admin/mft2"} "Materiales de Fabricacion de Tapas (Tubos o Fluxes)"]
   [:a.dropdown-item {:href "/admin/ft_mm"} "Métodos de Monitoreo (Ficha Técnica)"]
   [:a.dropdown-item {:href "/admin/ic_modelo"} "Modelos (Instrumentos de Control)"]
   [:a.dropdown-item {:href "/admin/recipientes"} "Recipientes"]
   [:a.dropdown-item {:href "/admin/dictamen_rp"} "Resultado de las Pruebas (Dictamen)"]
   [:a.dropdown-item {:href "/admin/dictamen_pf"} "Prueba de Funcionamiento (Dictamen)"]
   [:a.dropdown-item {:href "/admin/tdd"} "Tipo de Dispositivo"]
   (when (or
          (= (user-level) "A")
          (= (user-level) "S"))
     (list
      nil
      (when (= (user-level) "S")
        [:a.dropdown-item {:href "/admin/users"} "Usuarios"])))))

(defn menus-private []
  (list
   [:nav.navbar.navbar-expand-md.navbar-dark.bg-dark.fixed-top
    [:a.navbar-brand {:href "/"}
     [:img.rounded-circle {:src "/images/ast.png"
                           :alt (:site-name config)
                           :style "width:40px;"}]]
    [:button.navbar-toggler {:type "button"
                             :data-toggle "collapse"
                             :data-target "#collapsibleNavbar"}
     [:span.navbar-toggler-icon]]
    [:div#collapsibleNavbar.collapse.navbar-collapse
     [:ul.navbar-nav
      [:li.nav-item [:a.nav-link {:href "/users"} "Dashboard"]]
      (when
       (or
        (= (user-level) "U")
        (= (user-level) "A")
        (= (user-level) "S"))
        [:li.nav-item.dropdown
         [:a.nav-link.dropdown-toggle {:href "#"
                                       :id "navdrop"
                                       :data-toggle "dropdown"} "Administrar"]
         [:div.dropdown-menu
          (build-admin)]])
      [:li.nav-item [:a.nav-link {:href "/home/logoff"} (str "Salir [" (user-name) "]")]]]]]))

(defn menus-public []
  (list
   [:nav.navbar.navbar-expand-md.navbar-dark.bg-dark.fixed-top
    [:a.navbar-brand {:href "/"}
     [:img.rounded-circle {:src "/images/ast.png"
                           :alt (:site-name config)
                           :style "width:40px;"}]]
    [:button.navbar-toggler {:type "button"
                             :data-toggle "collapse"
                             :data-target "#collapsibleNavbar"}
     [:span.navbar-toggler-icon]]
    [:div#collapsibleNavbar.collapse.navbar-collapse
     [:ul.navbar-nav
      [:li.nav-item [:a.nav-link {:href "/home/login"} "Entrar al sitio"]]]]]))

(defn menus-none []
  (list
   [:nav.navbar.navbar-expand-md.navbar-dark.bg-dark.fixed-top
    [:a.navbar-brand {:href "/"}
     [:img.rounded-circle {:src "/images/ast.png"
                           :alt (:site-name config)
                           :style "width:40px;"}]]
    [:button.navbar-toggler {:type "button"
                             :data-toggle "collapse"
                             :data-target "#collapsibleNavbar"}
     [:span.navbar-toggler-icon]]
    [:div#collapsibleNavbar.collapse.navbar-collapse]]))

(defn app-css []
  (list
   (include-css "/bootstrap/css/bootstrap.min.css")
   (include-css "/bootstrap/css/lumen.min.css")
   (include-css "https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css")))

(defn app-js []
  (list
   (include-js "/js/jquery.js")
   (include-js "/popper/popper.min.js")
   (include-js "/bootstrap/js/bootstrap.min.js")
   (include-js "/js/extra.js")))

(defn application [title ok js & content]
  (html5 {:ng-app (:site-name config) :lang "en"}
         [:head
          [:title (if title
                    title
                    (:site-name config))]
          [:meta {:charset "UTF-8"}]
          [:meta {:name "viewport"
                  :content "width=device-width, initial-scale=1"}]
          (app-css)
          [:link {:rel "shortcut icon"
                  :type "image/x-icon"
                  :href "data:image/x-icon;,"}]]
         [:body
          [:div.container.flex-nowrap.overflow-auto.margin-top {:style "margin-top:75px;margin-bottom:25px;"}
           (cond
             (= ok -1) (menus-none)
             (= ok 0) (menus-public)
             (> ok 0) (menus-private))
           [:div {:style "padding-left:14px;"} content]]
          (app-js)
          js]
         [:footer.bg-secondary.text-center.fixed-bottom
          [:span  "Copyright &copy" (t/year (t/now)) " " (:company-name config) " - All Rights Reserved"]]))

(defn error-404 [content return-url]
  (html5 {:ng-app (:site-name config) :lang "es"}
         [:head
          [:title "Mesaje"]
          [:meta {:charset "UTF-8"}]
          [:meta {:name "viewport"
                  :content "width=device-width, initial-scale=1"}]
          (app-css)
          [:link {:rel "shortcut iconcompojure"
                  :type "image/x-icon"
                  :href "data:image/x-icon;,"}]]
         [:body
          [:div.container.flex-nowrap.overflow-auto.margin-top {:style "margin-top:75px;margin-bottom:25px;"}
           (menus-none)
           [:div {:style "padding-left:20px"}
            [:div
             [:p [:h4 [:b "Mensaje: "]] [:h5 content]]
             [:p [:h4 [:a {:href return-url} "Clic aquí para " [:strong "Continuar"]]]]]]]

          (app-js)
          nil]
         [:footer.bg-secondary.text-center.fixed-bottom
          [:span  "Copyright &copy" (t/year (t/now)) " " (:company-name config) " - All Rights Reserved"]]))
