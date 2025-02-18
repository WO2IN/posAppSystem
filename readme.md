# 최종 전처리
<br>

## ✅ 코드 설명
- 30만 라인 데이터 규격에 맞춰서 규격에 벗어나는 데이터는 `NaN`값으로 처리

<br>

## 🔧 주요 함수 설명
- #### **BetterwhyData.py** 함수
  - `final_processing()` : **30만 라인 규격 설정**
    - 인자값 : `df`(DataFrame)
    - 반환값 : `df`(DataFrame), `nun_cnt`(int)
    ---
  - `set_outliers_to_none()` : **설정한 규격을 받아서 규격에 넘는 데이터 NaN값으로 처리**
    - 인자값 : `df`(DataFrame), `column_ranges`(dict)
    - 반환값 : `df`(DataFrame), `error_cnt`(int)

<br>

## 📖 30만 라인 규격 

| 필드명                  | 유효 값 범위                       | 필드명                  | 유효 값 범위                       |
|-------------------------|------------------------------------|-------------------------|------------------------------------|
| `soh`                   | **0 ~ 100**　　　　　　　　　　    | `power_per_soc`         |**0 ~ 50**　　　　　　　　　　      |
| `p_volt`                | **0 ~ 1000**                       | `module_temp`           | **-50 ~ 100**                      |
| `p_current`             | **-500 ~ 500**                     | `temperature`           | **-50 ~ 50**                       |
| `cell_volt_diff`        | **0 ~ 5**                          | `mileage`               | **0 ~ 제한 없음**                  |
| `soc_start`             | **0 ~ 100**                        | `accum_mileage`         | **0 ~ 제한 없음**                  |
| `soc_end`               | **0 ~ 100**                        | `km_per_kWh`            | **0 ~ 10**                         |
| `soc_quan`              | **0 ~ 100**                        | `speed_0`               | **0 ~ 제한 없음**                  |
| `period`                | **1 ~ 86400**                      | `speed_0_30`            | **0 ~ 제한 없음**                  |
| `charge_discharge_speed`| **0 ~ 200**                        | `speed_30_60`           | **0 ~ 제한 없음**                  |
| `power_quan`            | **0 ~ 1000**                       | `speed_60_90`           | **0 ~ 제한 없음**                  |
| `power_per_hour`        | **0 ~ 1000**                       | `speed_90_180`          | **0 ~ 제한 없음**                  |
| `model_year`            | **2017 ~ 2025**                    | `model_month`           | **1 ~ 12**                         |

 <br>

## 📝 실행 결과
```python
>>==============================================================
1. 오류 데이터 처리 개수 : 0
2. 총 실행 시간: 0.22789 sec
----------------------------------------------------------------
데이터 규격에 맞게 전처리 완료. 데이터 저장을 완료했습니다.
==============================================================<<
```
