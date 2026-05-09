CREATE TABLE members (
     member_id BIGINT AUTO_INCREMENT PRIMARY KEY,
     login_id VARCHAR(50) NOT NULL UNIQUE,
     password VARCHAR(255) NOT NULL,
     name VARCHAR(50) NOT NULL,
     email VARCHAR(100),
     created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, -- 현재 시간 자동 입력
     updated_at DATETIME NULL,
     deleted_yn CHAR(1) NOT NULL DEFAULT 'N'
);