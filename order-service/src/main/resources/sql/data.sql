-- 기존 데이터 초기화
DELETE
FROM firstcome_system.wishlist;
ALTER TABLE firstcome_system.wishlist
    AUTO_INCREMENT = 1;

-- 기본 테스트 데이터 삽입
INSERT INTO firstcome_system.wishlist
    (wishlist_id, member_id, product_id, quantity, created_at, updated_at)
VALUES
-- member_id 1의 위시리스트 항목들
(1, 1, 1, 1, '2024-01-01 10:00:00', '2024-01-01 10:00:00'), -- 수량 증가/감소 테스트용
(2, 1, 2, 1, '2024-01-01 11:00:00', '2024-01-01 11:00:00'), -- 삭제 테스트용
(3, 1, 3, 2, '2024-01-01 12:00:00', '2024-01-01 12:00:00'), -- 일반 조회용
(4, 1, 4, 1, '2024-01-01 13:00:00', '2024-01-01 13:00:00'), -- 일반 조회용
(5, 1, 5, 3, '2024-01-01 14:00:00', '2024-01-01 14:00:00'), -- 페이지네이션 첫 페이지 마지막 항목

-- 두 번째 페이지 데이터
(6, 1, 6, 1, '2024-01-01 15:00:00', '2024-01-01 15:00:00'), -- 두 번째 페이지 시작
(7, 1, 7, 2, '2024-01-01 16:00:00', '2024-01-01 16:00:00'),
(8, 1, 8, 1, '2024-01-01 17:00:00', '2024-01-01 17:00:00'),

-- member_id 2의 위시리스트 항목들 (다른 사용자의 데이터)
(9, 2, 10, 1, '2024-01-01 18:00:00', '2024-01-01 18:00:00'),
(10, 2, 11, 2, '2024-01-01 19:00:00', '2024-01-01 19:00:00');