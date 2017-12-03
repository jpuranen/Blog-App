package fi.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.xml.stream.Location;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
public class MyRestController {

    @Autowired
    BlogRepository database;

    @PostConstruct
    public void init() {
        // called when spring has created the bean
    }

    @ApiOperation(value = "Add a blog", response = Blog.class)
    @RequestMapping(value = "/blogs",  method= RequestMethod.POST)
    public Blog saveBlog(@RequestBody Blog blog) {
        Blog savedObject = database.save(blog);
        return savedObject;
    }

    @ApiOperation(value = "View a list of all blogs", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved blog list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/blogs",  method=RequestMethod.GET)
    public Iterable<Blog> fetchBlog() {
        return database.findAll();
    }

    @ApiOperation(value = "View a blog", response = Blog.class)
    @RequestMapping(value = "/blogs/{blogId}",  method=RequestMethod.GET)
    public Blog fetchBlogWithId(@PathVariable("blogId") Long blogId) {
        return database.findOne(blogId);
    }

    @ApiOperation(value = "Delete a blog")
    @RequestMapping(value = "/blogs/{blogId}",  method=RequestMethod.DELETE)
    public void deleteBlogWithId(@PathVariable("blogId") Long blogId) {
        database.delete(blogId);
    }

    @ApiOperation(value = "Update a blog")
    @RequestMapping(value = "/blogs",  method=RequestMethod.PUT)
    public Blog updatelogWithId(@RequestBody Blog blog) {
        Blog savedBlog = database.save(blog);
        return savedBlog;

    }
}
