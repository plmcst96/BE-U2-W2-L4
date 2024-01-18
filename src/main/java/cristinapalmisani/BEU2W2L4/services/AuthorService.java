package cristinapalmisani.BEU2W2L4.services;

import cristinapalmisani.BEU2W2L4.entities.Author;
import cristinapalmisani.BEU2W2L4.exception.NotFoundException;
import cristinapalmisani.BEU2W2L4.payloads.author.AuthorDTO;
import cristinapalmisani.BEU2W2L4.repositories.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    private AuthorDao authorDao;

    public Page<Author> getAuthor(int page, int size, String orderBy) {
        if (size >= 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return authorDao.findAll(pageable);
    }

    public Author save(AuthorDTO body) {
        Author newAuthor = new Author();
        newAuthor.setAvatar("https://ui-avatars.com/api/?name=" + body.name() + "+" + body.surname());;
        newAuthor.setName(body.name());
        newAuthor.setSurname(body.surname());
        newAuthor.setEmail(body.email());
        newAuthor.setBirthDate(body.birthDate());
        return authorDao.save(newAuthor);
    }

    public Author findById(UUID id) {
        return authorDao.findById(id).orElseThrow(()-> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Author found = this.findById(id);
        authorDao.delete(found);
    }
    public Author findByIdAndUpdate(UUID id, Author body) {
        Author found = this.findById(id);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setBirthDate(body.getBirthDate());
        found.setEmail(body.getEmail());
        return authorDao.save(found);
    }
}
