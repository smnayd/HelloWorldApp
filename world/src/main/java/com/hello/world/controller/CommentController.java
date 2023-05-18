package com.hello.world.controller;

        import com.hello.world.entity.Comment;
        import com.hello.world.repository.CommentRepository;
        import com.hello.world.service.CommentService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Map;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment){
        try{
            Comment createdComment = commentService.createComment(comment);
            return new ResponseEntity<>(createdComment, HttpStatus.CREATED);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateCommentById(@RequestBody Map<String, Object> request, @PathVariable("id") int id){
        try{
            String updateComment = (String)request.get("comment");
            Comment comment = commentService.updateCommentById(updateComment,id);
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCommentById(@PathVariable("id") int id){
        try{
            commentService.deleteCommentById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getcomment/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") int id){
        try{
            Comment comment = commentService.getCommentById(id);
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Comment>> getByPostId(@PathVariable("id")int id){
        try{
            List<Comment> comments = commentService.getByPostId(id);
            return new ResponseEntity<>(comments,HttpStatus.OK);
        }
        catch (Exception ex){
            ex.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
