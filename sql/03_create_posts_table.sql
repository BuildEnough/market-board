CREATE TABLE posts (
       post_id BIGINT AUTO_INCREMENT PRIMARY KEY,
       member_id BIGINT NOT NULL,
       title VARCHAR(200) NOT NULL,
       content TEXT NOT NULL,
       view_count INT NOT NULL DEFAULT 0, -- 처음 작성되는 글은 아직 조회되지 않아서 0
       created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
       updated_at DATETIME NULL,
       deleted_yn CHAR(1) NOT NULL DEFAULT 'N',
       CONSTRAINT fk_posts_member
           FOREIGN KEY (member_id) REFERENCES members(member_id)
);

-- 실행할 때 전체 드래그하고 실행