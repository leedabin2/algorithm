-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', F.BOARD_ID, '/', F.FILE_ID, F.FILE_NAME, F.FILE_EXT)AS FILE_PATH
from USED_GOODS_FILE F
where F.BOARD_ID = (
 select BOARD_ID	
from USED_GOODS_BOARD
order by VIEWS DESC
    limit 1
)
order by F.FILE_ID DESC;

