package fi.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.xml.stream.Location;

@RestController
public class MyRestController {

    @Autowired
    BlogRepository database;

    @PostConstruct
    public void init() {
        // called when spring has created the bean
    }
    @RequestMapping(value = "/blogs",  method= RequestMethod.POST)
    public Blog saveBlog(@RequestBody Blog b) {
        Blog savedObject = database.save(b);
        return savedObject;
    }

    @RequestMapping(value = "/blogs",  method=RequestMethod.GET)
    public Iterable<Blog> fetchBlog() {
        return database.findAll();
    }

    @RequestMapping(value = "/blogs/{blogId}",  method=RequestMethod.GET)
    public Blog fetchBlogWithId(@PathVariable("blogId") Long blogId) {
        return database.findOne(blogId);
    }
    @RequestMapping(value = "/blogs/{blogId}",  method=RequestMethod.DELETE)
    public void deleteBlogWithId(@PathVariable("blogId") Long blogId) {
        database.delete(blogId);
    }
}
