package cristinapalmisani.BEU2W2L4.services;

import cristinapalmisani.BEU2W2L4.entities.Author;
import cristinapalmisani.BEU2W2L4.entities.BlogPost;
import cristinapalmisani.BEU2W2L4.exception.NotFoundException;
import cristinapalmisani.BEU2W2L4.payloads.blog.BlogPostDTO;
import cristinapalmisani.BEU2W2L4.repositories.BlogPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostDao blogPostDao;
    @Autowired
    private AuthorService authorService;

    public Page<BlogPost> getBlog(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return blogPostDao.findAll(pageable);
    }

    public BlogPost save(BlogPostDTO body) {
        Author author = authorService.findById(body.authorId());
       BlogPost post = new BlogPost();
        post.setTitle(body.title());
        post.setCategory(body.category());
        post.setContent(body.content());
        post.setReadingTime(body.readingTime());
        post.setCover("https://picsium.photos/200/300");
        post.setAuthor(author);
        return blogPostDao.save(post);
    }

    public BlogPost findById(UUID id) {
        return blogPostDao.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        BlogPost found = this.findById(id);
        blogPostDao.delete(found);
}

    public BlogPost findByIdAndUpdate(UUID id, BlogPost body) {
        BlogPost found = this.findById(id);
        found.setTitle(body.getTitle());
        found.setCategory(body.getCategory());
        found.setContent(body.getContent());
        found.setReadingTime(body.getReadingTime());
        return blogPostDao.save(found);
    }

    public Page<BlogPost> getBlogPostsByAuthorId(UUID id, int page, int size, String orderBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return blogPostDao.getBlogPostsByAuthorId(id, pageable);
    }
}
