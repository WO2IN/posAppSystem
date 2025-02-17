# Betterwhy Data
```bash
├── Main.py # Betterwhy 모듈 테스트 파일
├── BetterwhyData.py # Betterwhy 데이터 관련 모듈 정의
└── readme.md
```
#### [**1차 데이터 전처리 설명**](#first_processing)
#### [**충/방전 구간 분류 설명**](#classify_charging)
#### [**구간데이터 통계 추출**](#section_statistics)
#### [**최종 전처리**](#final_processing)

## 📌 BetterwhyData 모듈 설명
<a id="first_processing"></a>
## ➖ **first_processing()**

#### ✅ 기능
- 차량 데이터 `pd.DataFrame`를 입력받아 `clientid`를 기준으로 `betterwhy_cartype_list.csv`의 정보를 매칭  
- `car_type`, `model_year`, `model_month` 필드 추가  
- 이상값 (`SOC`, `SOH`, `전류`, `온도`)은 `NaN`으로 변환  

#### 🔹 입력값
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 차량 데이터 (`clientid` 필드 포함) |

#### 🔹 출력값
| 반환값 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 차종 정보 추가 및 이상값이 처리된 데이터 |

---

<a id="classify_charging"></a>
## ➖ **get_{TYPE}_charge_list()**

#### ✅ 기능
- 각 함수는 **충/방전 구간**을 분류하고, 해당 구간들을 **리스트 형태로 반환**
- 각 구간은 **충전 상태**(`chg_state`) 에 따라 필터링되고, `SOC` 변화량과 시간 차이를 기준으로 구분 
- 급속 충전은 `fast_chg_current` 필드, 완속 충전은 `slow_chg_current` 필드를 기준으로, 방전 구간은 **충전 상태**(`chg_state`) 가 0일 때, SOC 변화량과 시간 차이만으로 구분

#### 🔹 입력값
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 구간을 추출할 데이터 |

#### 🔹 출력값
| 반환값 | 타입 | 설명 |
|-|-|-|
| `{TYPE}_charge_list` | `List[pd.DataFrame]` | `{TYPE}`에 해당하는 구간이 포함된 데이터프레임들의 리스트 |

---

<a id="section_statistics"></a>
## ➖ **section_statistics**

#### ✅ 기능
- 주어진 데이터프레임에서 차량 구간별 통계 값을 추출하여 데이터프레임 형태로 반환
- 차량 정보, 충전/방전 구간, 전력량, SOC 변화량, 주행거리, 전비, 온도, 충전 속도 등 다양한 지표를 계산하여 반환

#### 🔹 입력값
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 구간 통계를 계산할 데이터 |
| `csv_file` | `str` | 파일 경로, 충전/방전 타입을 결정하는데 사용 |

#### 🔹 출력값
| 반환값 | 타입 | 설명 |
|-|-|-|
| `pd.DataFrame` | `pd.DataFrame` | 각 구간에 대한 다양한 통계 정보가 포함된 데이터프레임 |

---

<a id="final_processing"></a>
## ➖ **final_processing**

#### ✅ 기능
- 데이터프레임에 대해 범위 검증을 수행하고, 각 열의 값이 정상 범위 내에 있는지 확인
- 각 열에 대해 범위를 벗어난 값을 `None`으로 처리하여 이상치를 제거

#### 🔹 입력값
| 매개변수 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 이상치를 처리할 데이터프레임 |

#### 🔹 출력값
| 반환값 | 타입 | 설명 |
|-|-|-|
| `df` | `pd.DataFrame` | 이상치가 처리된 데이터프레임 |



## 📝 진행사항
#### ✅ 완료된 작업
-  충/방전 구간 분류 모듈화 **(2025.01.24)**
-  구간 데이터 통계 추출 모듈화 **(2025.01.24)**
-  1차 전처리 모듈화 **(2025.02.10)**
-  최종 전처리 모듈화 **(2025.02.11)**
  
#### ⏳ 진행 중
- README 작성 중 . . .
