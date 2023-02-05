-- 코드를 입력하세요
SELECT I.FOOD_TYPE,I.REST_ID,I.REST_NAME,I.FAVORITES
FROM REST_INFO I
JOIN (
    SELECT FOOD_TYPE,MAX(FAVORITES) AS FAVORITES
    FROM REST_INFO
    GROUP BY FOOD_TYPE
) AS M ON I.FOOD_TYPE = M.FOOD_TYPE AND I.FAVORITES = M.FAVORITES
ORDER BY I.FOOD_TYPE DESC