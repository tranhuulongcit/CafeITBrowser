package info.cafeit.controller

import javafx.application.Application
import javafx.fxml.Initializable
import javafx.stage.Stage
import java.net.URL
import java.util.*

open class BaseController : Initializable {

    lateinit var context: Stage

    var args: Application.Parameters? = null;

    override fun initialize(location: URL?, resources: ResourceBundle?) {
    }

}