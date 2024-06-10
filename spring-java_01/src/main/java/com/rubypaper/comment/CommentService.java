package com.rubypaper.comment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.user.SiteUser;
import com.rubypaper.travel.Travel;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment create(Travel Travel, SiteUser author, String content) {
        Comment c = new Comment();
        c.setContent(content);
        c.setCreateDate(LocalDateTime.now());
        c.setTravel(Travel);
        c.setAuthor(author);
        c = this.commentRepository.save(c);
        return c;
    }

    public Optional<Comment> getComment(Integer id) {
        return this.commentRepository.findById(id);
    }

    public Comment modify(Comment c, String content) {
        c.setContent(content);
        c.setModifyDate(LocalDateTime.now());
        c = this.commentRepository.save(c);
        return c;
    }

    public void delete(Comment c) {
        this.commentRepository.delete(c);
    }
}
