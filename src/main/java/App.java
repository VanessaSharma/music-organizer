import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/MusicOrg/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/album-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/MusicOrg", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("albums", MusicOrg.all());
      model.put("template", "templates/albums.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/MusicOrg", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String description = request.queryParams("description");
      MusicOrg newAlbum = new MusicOrg(description);
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/MusicOrg/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      MusicOrg album = MusicOrg.find(Integer.parseInt(request.params(":id")));
      model.put("albums", album);
      model.put("template", "templates/album.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // old code below
    //
    // get("/", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("albums", request.session().attribute("albums"));
    //   model.put("template", "templates/index.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // post("/MusicOrg", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //
    //   ArrayList<MusicOrg> albums = request.session().attribute("albums");
    //   if (albums == null) {
    //     albums = new ArrayList<MusicOrg>();
    //     request.session().attribute("albums", albums);
    //   }
    //
    //   String description = request.queryParams("description");
    //   MusicOrg newAlbum = new MusicOrg(description);
    //   albums.add(newAlbum);
    //
    //   model.put("template", "templates/success.vtl");
    //   return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());
  }
}
