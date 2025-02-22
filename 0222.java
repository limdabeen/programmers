#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// id_pw_len은 배열 id_pw의 길이입니다.
// db_rows는 2차원 배열 db의 행 길이, db_cols는 2차원 배열 db의 열 길이입니다.
char* solution(const char* id_pw[], size_t id_pw_len, const char*** db, size_t db_rows, size_t db_cols) {
    // ID와 비밀번호 변수 설정
    const char* input_id = id_pw[0];
    const char* input_pw = id_pw[1];

    // ID 존재 여부 확인
    bool id_found = false;

    for (size_t i = 0; i < db_rows; i++) {
        const char* db_id = db[i][0];
        const char* db_pw = db[i][1];

        if (strcmp(input_id, db_id) == 0) { // ID 일치 확인
            id_found = true;
            if (strcmp(input_pw, db_pw) == 0) { // 비밀번호 일치 확인
                char* result = (char*)malloc(6);
                strcpy(result, "login");
                return result;
            } else {
                char* result = (char*)malloc(10);
                strcpy(result, "wrong pw");
                return result;
            }
        }
    }

    // ID가 아예 없는 경우
    char* result = (char*)malloc(5);
    strcpy(result, "fail");
    return result;
}