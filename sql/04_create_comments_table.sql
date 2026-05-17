CREATE TABLE comments (
      comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
      post_id BIGINT NOT NULL,
      member_id BIGINT NOT NULL,
      content VARCHAR(1000) NOT NULL,
      created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
      updated_at DATETIME NULL,
      deleted_yn CHAR(1) NOT NULL DEFAULT 'N',

      CONSTRAINT fk_comments_post
          FOREIGN KEY (post_id)
          REFERENCES posts(post_id),

      CONSTRAINT fk_comments_member
          FOREIGN KEY (member_id)
          REFERENCES members(member_id)
);