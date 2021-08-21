package info.cafeit

import info.cafeit.controller.MainController
import javafx.application.Application
import javafx.application.Platform
import javafx.collections.ListChangeListener
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.web.WebView
import javafx.stage.Stage
import javafx.stage.StageStyle
import java.io.File


class CafeITBrowser : Application() {
    override fun start(primaryStage:Stage) {
        try {
            val webView = WebView()
            val webEngine = webView.engine

            webView?.getChildrenUnmodifiable()?.addListener(ListChangeListener<Any?> {
                val deadSeaScrolls: MutableSet<javafx.scene.Node>? = webView!!.lookupAll(".scroll-bar")
                if (deadSeaScrolls != null) {
                    for (scroll in deadSeaScrolls) {
                        scroll.setVisible(false)
                    }
                }
            })
            val f = File("/Users/longtran/Documents/phatnhacv2-master/src/main/resources/static/fileupload/presentation/index.html")
            webEngine?.load(f.toURI().toString())
//            parameters?.apply {
//                var path: String = named["path"].toString()
//
//            }

            val scene = Scene(webView, 960.0,600.0)
            primaryStage.title = "Command browser"
            primaryStage.scene = scene
            primaryStage.initStyle(StageStyle.UNDECORATED)
            primaryStage.isMaximized = true
            primaryStage.isFullScreen = true
            primaryStage.show()

            primaryStage.addEventFilter(KeyEvent.KEY_PRESSED) { e ->
                if (e.code == KeyCode.ESCAPE) {
                    Platform.exit();
                    System.exit(0);
                }
            }
        } catch (e:Exception) {
            e.printStackTrace()
        }
    }
}