package info.cafeit.controller

import javafx.collections.ListChangeListener
import javafx.fxml.FXML
import javafx.scene.web.WebEngine
import javafx.scene.web.WebView
import java.io.File
import java.net.URL
import java.util.*


class MainController : BaseController() {

    @FXML
    private var webView: WebView? = null;

    private var webEngine: WebEngine? = null;

    override fun initialize(location: URL?, resources: ResourceBundle?) {
        webEngine = webView?.engine;
        webView?.getChildrenUnmodifiable()?.addListener(ListChangeListener<Any?> {
            val deadSeaScrolls: MutableSet<javafx.scene.Node>? = webView!!.lookupAll(".scroll-bar")
            if (deadSeaScrolls != null) {
                for (scroll in deadSeaScrolls) {
                    scroll.setVisible(false)
                }
            }
        })

        val f = File("/Users/longtran/Documents/client/index.html")
        webEngine?.load(f.toURI().toString())

//        args?.apply {
//            var path: String = named["path"].toString()
//            webEngine?.load(path)
//        }
    }
}