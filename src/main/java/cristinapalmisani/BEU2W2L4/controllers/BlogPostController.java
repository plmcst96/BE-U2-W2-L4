package cristinapalmisani.BEU2W2L4.controllers;

import cristinapalmisani.BEU2W2L4.entities.BlogPost;
import cristinapalmisani.BEU2W2L4.exception.BadRequestException;
import cristinapalmisani.BEU2W2L4.payloads.blog.BlogPostDTO;
import cristinapalmisani.BEU2W2L4.payloads.blog.BlogResponseDTO;
import cristinapalmisani.BEU2W2L4.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;

    // GET lista blog
    @GetMapping
    public Page<BlogPost> getBlog(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "id") String orderBy){
        return blogPostService.getBlog(page, size, orderBy);
    }

    // GET singolo blog
    @GetMapping("/{id}")
    public BlogPost findById(@PathVariable UUID id) {
        return blogPostService.findById(id);
    }

    // POST nuovo blog
    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public BlogResponseDTO saveBlog(@RequestBody @Validated BlogPostDTO body, BindingResult validation) {
        if (validation.hasErrors()){
            System.out.println(validation.getAllErrors());
            throw new BadRequestException("Ci sono errori nel payload!");
        } else {
            BlogPost newBlog = blogPostService.save(body);
            return new BlogResponseDTO(newBlog.getId());
        }

    }

    //PUT modifica il blogPost
    @PutMapping("/{id}")
    public BlogPost findByAndUpdate(@PathVariable UUID id, @RequestBody BlogPost body) {
        return this.blogPostService.findByIdAndUpdate(id, body);}

    //DELETE elimina post
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable UUID id){
        this.blogPostService.findByIdAndDelete(id);
    }

    @GetMapping("author/{id}")
    public Page<BlogPost> getBlogPostsByAuthorId(@PathVariable UUID id,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(defaultValue = "id") String sort) {
        return blogPostService.getBlogPostsByAuthorId(id, page, size, sort);
    }


}
