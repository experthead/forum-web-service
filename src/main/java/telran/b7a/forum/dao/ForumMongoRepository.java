package telran.b7a.forum.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import telran.b7a.forum.model.Post;

public interface ForumMongoRepository extends MongoRepository<Post, String> {

	public Stream<Post> findPostsByAuthor(String author);

	@Query(value = "{ tags: {$in: ?0}}")
	public Stream<Post> findPostsByTags(List<String> tags);

	@Query(value = "{ dateCreated: {$gte: ?0, $lt: ?1}}")
	public Stream<Post> findPostsByDateCreated(LocalDateTime from, LocalDateTime to);
}
