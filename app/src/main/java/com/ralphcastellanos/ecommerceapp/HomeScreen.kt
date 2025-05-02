package com.ralphcastellanos.ecommerceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onClickLogout:() -> Unit = {}){
    val auth = Firebase.auth
    val user = auth.currentUser
    Scaffold(
        topBar = {
            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Bienvenido",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        auth.signOut()
                        onClickLogout()
                    }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            if(user != null){
                Text(user.email.toString())
            }else{
                Text("No hay usuario")
            }

            Text(text = "Promociones destacadas",
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 8.dp))

            val listadoPromociones = listOf(
                "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxASERUSEhIWFRUVGRkVFRcVFRUVFxUVFxUWFhcRFRgYHSggGB0lGxcWITEhJSkrLi8uGB8zODMsNygtLisBCgoKDg0OGxAQGy0mICUwLy0tLy8tLy0rLy0tLS8tKy0tLy0tLS0tLS0tLS0tLS0tLS0tLS0tLSstLS0tLS0tLf/AABEIAJ4BPwMBEQACEQEDEQH/xAAbAAABBQEBAAAAAAAAAAAAAAAAAQIEBQYDB//EAEoQAAIBAgMEBAkHCgQGAwAAAAECAwARBBIhBRMxUQYiQWEHFDJxgZGTsdEWNFNUc5KyFRcjJDNCUqHS8IKjs8KipLTB4fE1Y3L/xAAbAQEAAgMBAQAAAAAAAAAAAAAABAUBAgMGB//EADkRAAIBAgMEBwcCBgMBAAAAAAABAgMRBAUhEjFBcRMVMlFSkcEUIjM0YYGhsdEGI2Jy4fBCovHC/9oADAMBAAIRAxEAPwD3GgCgCgCgCgCgCgCgCgCgCgCgCgCgCgIeL2nDG2V361r5QCzZeGYqoJA0OtAS1a4BHbrQC0AUA12ABJ4DU9vDzUBA/LcHN/ZS/wBNAH5bg5v7KX+mgD8twc39lL/TQB+W4Ob+yl/poCRg8fFLfduCVtmGoZb8MynUX7xQEmgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgKOKdYJJ1lVxvHziRUkYOpRVALIDkZbZbGxsoI4mwFRGZAB+uy3yoMxhnbrKoznKRYhmue4G1AdcLPJHY+Nu57Q8E+XSMrfyb3zEE8BpzuaA5AyZQDjZWYZQTusQuYK0hJIANiVMQJH8BP7xoCzx2O3lljndDvEYfoJh1AADGxsL3Nze45UAR7IxgFmxZJs4BykWYoqiTQ69YM2U6DPYcBQErA4LFJLmknDoTISuUrYOYyijU3yZXAJ7H7tQIK7ExotfGs1lYcCupQKraHWxBOvEk8OFAPfA4uMK7Yvqoysw3bvdQ7fotDc9RwubU3RTQEmCUTYpZI1YJHG6M7I8eYu0ZVFDAFwMrEtwFwBxNgLigCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgCgENAZTDw7ZUAtJG9lHVORSZfFVWzMq6IJwWuNeuewAUAPDtfJbOM4idFZWhKmULMFmkzRXJJ3BsoVb57iwAIEvHRbSMEe5cCUK+83gjGYnRPJBVSL5ha46oB4kgDmuF2kWa8xUbxCMu4PU3rZwt4zZd0Utmu2YHW2pA67Ri2lviYXTd5tFbLqhGHGhykhgd+wvcHgbXBUDnHHtILYtdmWVSSYcqSEJupEAQHdgh9GzNrregEaPabOGDZATfKTCVVcwBV+pmJyhiuU8SLmwtQDNnw7U/Q7yQkgLvbiAKxzneXCLfVLZcpGup00oDUUAUAUAUAUAUAUAUAUAUAUAUAUAUAUAUAUAUAUAUBR7U6RCGQx7stYA3zW4i/KqvFZmqFTo3G5Pw+AdaG2pWInyvX6E/eHwqP13HwPzO/VUvEvIPlev0J+8PhTruPgfmOqpeJeQfK9foT94fCnXcfA/MdVS8S8g+V6/Qn7w+FOu4+B+Y6ql4l5B8r1+hP3h8Kddx8D8x1VLxLyD5Xr9CfvD4U67j4H5jqqXiXkHyvX6E/fHwp13HwPzHVUvEvIPlev0J++PhTruPgfmOqpeJeQfK9foT94fCnXcfA/MdVS8S8g+V6/Qn74+FOu4+B+Y6ql4l5B8r1+hP3h8Kddx8D8x1VLxLyD5Xr9Cfvj4U67j4H5jqqXiXkHyvX6E/fHwp13HwPzHVUvEvIPlev0J+8PhTruPgfmOqpeJeRV9IPCQmFRXbDs2Zstg4FtCb6juq0yqv1hUlCK2bK+pCxuG9lgpN3uUX57IfqcntV/pq+6qn4kVvtMe4Pz2w/U5Par/AE06qn4kPaYifnuh+pSe1X4U6qn4kZ9piH57ofqUntF/pp1VPxIe0xOx8Mi5c/iE2WwbNnXLYsUBvlt5QI9FadWu9ttXN+l0vbQ4fnvh+pSe1T4Vv1TPxI09oiH58IfqUntE+FOqZ+JD2iIn58IfqUntU+FOqZ+JGfaIh+fGH6lJ7RPhTqmfiX5HTxE/PlD9Sk9onwp1TPxL8meniJ+fOH6lJ7RPhTqmfiX5HTRD8+cP1KX2ifCsdVSX/JDpoh+fSD6lJ7RPhWeqZ3ttL8memQDw5wfUpPaJ8K1eV1E7XRjpkA8OcH1KT2ifCksrmlfaQ6ZGo6C+EKPacskawNFu1Dks4a92tYWFRK+GdKKd73N4VFLcbWoxuFAFAFAFAFAFANagMJ0m+cN5l91eUzX5l8keiy74C5sqqricFAFAFAFAFAFAFAFAFAFAFAFAFAZPwi/sI/tP9jV63+Efman9vqiiz74EefoYG1e/PKCWoLhaguKkZYhQLkkAAcSSbADvvWJSSV2bRTbsjYdKtkTw4eGFmRY4ow7kmwedmdt2ml3IDHuF9bVT4LEU6taU+Len0XeWWJpyhSjHglrzMZlq5Ky4mWhm4hWhm4mWsi40rQ2uNK0M3EtXNxu9dxm4lNm8kwMtW9zYfUf3trZkYPTPAOx8axH2a/jqBmcUoRt3kihxPeo+FUxIHUAUAUAUAUAUA16AwfSX5w3mX3V5TNfmXyR6LLvgLmyrquJwUAUAUAUAUAUAUAUAUAUAUAUAUBlPCJ+wj+0/2NXrP4R+Zqf2+qKLP/gx5+hgrV9APJ3C1AKiEmwGtZSuYckldmw2dFh9nxLiXKTYlxeJFN0iv2nm/PlwHOqPFTrYqq8PBbMVvZaUFTo01Wbu3uM7tra0uKk3kp14ADgo5AVY4XCQw0NmH3ZDr4iVaV5FfapRwEtQBahkS1BcQihm40rQzcYwrjWfumyGWrFLcbXC1HTcpX4AZau5semeAj51iPs1/HVVmvYjzZIocT3qPhVISB9AFAFAFAFAFANegMH0l+cN5l91eUzX5l8keiy74C5sr4oXbyVZrccqlree1QIU5z7Kb5EuU4w7TsdPEJvopPZv8K6ez1vA/JmntFLxLzOMiFTZgQRxBBBHoNcpRcXZqzOsZKSumKsTEXCkjmAbeusqEmrpM1dSKdm0MrU3HmJrXym3Oxt663dOaV7PyNOkje10NVSTYC55DWtUm3ZGzaSuwZSDYgg8iLUaadmFJNXQlYMhQBQBQBQFXtDbIjbIiNI/bYhVXtszH/sDVhhsuqVltPREOvjIU3beyp2xgsXjMK0m6RRE91CyFy/VIZRdRqLjz16XJqdPAV3KT0aty4lPmE54ulZLc7mQl2Nil1MEv3GPuFephmeDm7Rqx80UcsDiI74PyIscDE5bWI437PPU6Fp9kiTex2iVO6wrZRdjoDpeus5KmtN5whF1nd7iACeJNya4JO93vJLatZbha2MBQEjA4Cad8kMbyPYnLGpdrDibDs1HrrSc4wV5OxtGLlohuOwcsLZJo3iYa5ZFZDY8DZgDbQ61mE4zV4u5lxadmjps/ZeIxBYQQySlQC27Rnyg3sTlGnA+qsTqQh2nYRhKW5DcPs2aSJ5kidoo7Z5ApKLe1gW4do9YpKpGMlFvVmVCTV7ENiK3NbMm4fYWKliMsUErxg5S6xsy34WuB3jzVGq1Kd9lySZ1jCTV0jhtDZk2HYJNE8TEZgsilCVJIzAN2XB9Vb05QcfcdxJNPUhWraDZgaRWzqK9jZHpXgJ+dYj7Nfx1V5r2I82SaHE95j4VSkkfQBQBQBQBQBQDWoDB9JfnDeZfdXlM1+ZfJHosu+AubLHoR5cvmX3tUrJO3PkvUjZruj9/QtcLtkvi3w+VLKCbiRWa4y8VBuNHXS2mnMV6RwtG5S31sUG1XjGOYyglAVuB29RbecV5TFSpxxrdRXX+C/w6qSwiVN6/5L+Pb8BkSKMFs1gCosq34C3H+WlW0cxoupGlDW/duK2WCqqDqS0t37zs2xYTNvsovbhbQt/HbnXV4Gi63S2/bmaLFVFS6O+n+6HKLb8LTbmzcSoYgZSR2cb1zjmNKdbobPuvwN5YKpGl0v8A6dhgFhEjwxgu2oHAXt5I5C+tu+uqw8aKlOlH3n/tjm60qrjGpLRFX0jiL4eN3QCYlQANTduKDnztUHMYOph4ynG09NOfAl4GahXkov3df/Sj2jgUhRVZiZjqwFsqKeCnv/vlVViMPChBRb9/j3IsaFedabaXuflldUImBQBQCigPHhtnF4mUxRnrOWsBYcAWbXzA17aKUYruR5h3nL6nqnRlETBRpKrM8RLsLg5pLlrd41ArhKV2SowstSi6SYjaKYhngVhFYEKqAgaagq92B82nKpeGwuUygoV0lN/YjV62OjLapXcUZfG7TlkYvKRmPLQBQOA5c/OTXrsFhaeCoqlT3Hm8VWniqvSSOEmxptyuL0ZH5G5jW5AzefQ917Gq6jmlGpi5UJaSW6/HkWFTAVIYeNSOseNuHMgValeFAFAazwZ7WgwuNMs8m7QwyJmszWZittFBPYah46nKpTSir6kjDyUZamxw3SzZyS4eKaZ5ngw7xrjZoWJ3rsljlYFuCnrEHjxNyar3hqzjKUVZN7kyU6sFKzK3ZHSvBR7ZmxCybrDSRlSVR0SSQBbOYxcjXNxHM6XrvPDVHhoxavJPyRzjVh0jd9BMF0q2Z+RpMEBNEwgVchVP0s56zSKyk/vgXzW6trCsSw1f2hVHZ6+SM9NTcGid0Y6VbMjwMMbSpGywypJGcOzM07WtMJQDYHraduccMtaV8NWdVytfXv4GadWGyio6L9IMPBsl4vygyYlkkVIzFKyQhmYlY8oAzubHOScpbhob716Mp177GnPeYhUiobyl8Jm24cVPBJFJvMuGjjckMDvAzlgcwBJ6w17664VSowakt7OdZqbVmZEcKmRd1c48TiK4Q7Ruz0zwGD9an+zX8dRs1XuR5skYfie8R8KpCUOoAoAoAoAoAoBrUBg+kvzhvMvuryma/Mvkj0WXfAXNlj0I8uXzL72qVknbnyXqRs13R+/oWkEI8ddhKx6tmQLLlBKx2u193ewBtbN1+Nq9K37lrFJxM10jUnFSAC5JUADtORdBXjsxTeKkl9P0PS4FpYdN/Uv9ibKXDIZpfLtr25ByFuJ/9ee3wWDjhodLU7X6FZi8VKvLYhu/Um7G2iZw5KlbNZQRY5cosT33vUrB4l11JtWs9ORHxFBUmle+n5MngsI/japY3WS58ytfN5rD+defo0J+1qNtz9S6q1oeyt33ovulOPkiMW7Yhjm0GtxoLWPHWrXNMTUpOCpvVldgKEKm1trREeOSVWTeNmxMmiKbZYVPFyBpe3utzrlGdSMo9I71Jblwiu/mbSjCSlsK0Fv739DpJsLDMxj3rGa2Ykm51/eItbt4d9bSy7Dzk4bT29+8RxteMVJRWzuMriISjMh4qSp84NqoKkHTm4vgXVOanFSXE51otdxuVO0ekmDg0kmW/wDCt3b0hb29NWOHynF19YQdu96EapjKNPfLy1LSCVXAZCGDagjUEd1QZUpwnsSWqO6nFx2k9DyleiGOXFO6kYVUlcrPK+7AGYkFLXZuryB5G1ezo+/GK4u2n1PM1E4tvuvqazAYy6a4phMoJdiSVlt+8mcAjzEA91Sa+W1qCUpLR93A1o5hSrXSeq/JlcR0xxMzG8zWAIsLLcHs4a+erHD4LBtpuN2tbvv+hDq4nEWaUrJ6aEPB5Jpkjd8iubM3IWufWbD01Ox+KnToynTW07biNhMPGVRRm7IvcHiJdnzmKXrRP5QtdWU6bxRzHAj0cjVPXpUc4wqrUdKkd3emuD9CfSnUy+v0dTWD39zXeROkuyxBL1NY5BnjPHTtW/ba49BFTsmzB4uhap246S/f7kXMcIqFW8ey9UVFXBXhQGt8HWFwckk4xIhZxCTAmIfdxM/bnbssLegsbaaQcdKpGK2L79bEnDKN3c9Hx0ex8RipXmfDyuI4VG8lGQQhWJZGzAZr3udSOrprrWReIhBKN0rvzJbUG9TH9Fo9lrFiHkihlHjyRQiV7MMM8iIH11ICsWuRbQ3qZiHXcopNr3bu3ecqahZ7t5cfk3YTyBWSGJIcYYria++iMGcM5JuU3rBeQy2va4rj0mJS3t3V927U32KfkyVLszYwZC8WC/Y4ppFimDLnV4t2A5sQ2XNbTS5twrmquIaest6M7MO5FPJgtlS7LbFJBh41beb5mmkE2HmzDdwwgIc+nBSAG6p7Sa3lUrwq7G02+Hc13mFGEo3scOn+ztkJgs2GGHD50GGMMpkkliKLvGnHYQc3HkutyRXTCyrTqe/drjf0NKygoaHmbEAVaOSiiGk2xrAVh2WtjZXPR/Ad86n+zX8dV2aO8I82S8NxPd4+FUpKHUAUAUAmYc6AMwoBM45igEZxzHroDCdJT+sN5l91eUzX5l8keiy74C5ssehHly+Zfe1Ssk7c+S9SNmu6P39CdhlI2hIcvFL5jlPBYhZTkuF1PVz8QTlswNelfw0UnErMbi1ix7SMCQLaC19YwO3z15evWjRxznJbv2L2lSlVwahH/dSzi6URsbLDKx5KoJ9QNToZtCekYSfJXIksunDWUor7nPH9IXQqRDIov1hIuUMCOw871pXzKUGmoNLjdW0NqOBjO6219LM6r0oiI6scjN/CFB9xrdZtSa92Lb7rGry6pHtNJd9ygxOLxLzCbduGHkjdsQoHZqO861UVa2InW6XZd1u0en4LGnSw8aXR7S136nCKScTb3K7OCGN1bt7DpoCNK5RnXVbpbNyTvuZ1lGi6XR3SXM0R2ygvIMLLvSMt92fUW429FXTx0F/MVKW1/b6lV7JLsOotnn6GTxEjM7M3lEkns1J1FuyvPVJynJylvZeU4qMUo7jGdLNjyyMCJ5WznKsGbRmP8AFhpxObQcxX0vJaODWFhU6NJ2u2UeL2tt7UnbuNHsHwfYKHCt4zGr6FpJG0I08mN7XQAdo49vIYr4yUp3houBW31Mf4OttxePbiASBZJCsGZyVyhSczA6rorNpqbhSRa9VteEa0lKSV+9HeNaUVs8C98K2wZVWPEmVmObLIt+opIGQLYaLow4a3FTMtoRc7yeq1RFxdZ7NktHoYbHKrxEHXs4+b/wA16OracWiipNwqXKrD4dVfQ38/Ll31Ep04wkTZ1ZSiclQBm8+ncOVYjpJmzltRRq994zgDm1kw50J4lO/0fgFUUV7DmaUexV4fUtW/asE9rtQ/Q6K+/wBmG+rYd9OeU2081m/4a2t7LnKtuqr8/wDpj4+Xa74P8Gbr1JSBQwFAdcJhzJIka2zOyot+GZmCi/dc1rKWynJ8DMVd2J5wGE+uf5Elcukq+D8o69HBf8vwHiOE+uf5Enxp0lXwf9kNiHi/AhwGE+t/8vJ8aOpVa7H/AGX7DYh4vwLicXiIIPFY5w+FnAm6saoXyysnXJXOLSQtpe2g51wpUbz22tVpv/3vOlSTjGy3MqGv2CpUtpdkjq3EazDgeNYlKL0lvNknvQOBxraSjvZhXPRvAgw8an+zX8YqszRpwjbvJmF3s90jcW4j11SksfmHOgDMOdAGYc6ApBO3/f08/R2cqAXfHu/8do9PbQDWa5uaAa1AZja37U+j3V5TNfmXyR6LLvgLmy56EeXL5l97VKyTtz5L1I2a7o/f0LGCSM49wIzmCG77xyCbRg/o7bsHQLmvn6lrW1r0uuwUnEotsYcyY1oxxZlHm6i3Pqua8ljKTq41wXFr9D0OFqKnhNt8L/qaHE4mDBRqoW5PAC12I4sxq4qVaOAppJfuysp06uLm22c9m7finbdMmUtwBIZW5jz1phsxp4iXRyVr+TN8RgalBbad0cMJs0QY0ZfIdGKjla1193rrjSwqoY5bO5p+h0qYh1sL729NErau3lgkyFC2ga4IHEkW/lUnFZgqE9hxbOGHwbrR2k0huwMaJpJpACAd2LHuDVjA11XqTmlbd6m2LoulCEW77zli+k6RuyGNjlJW9xratKuaxpzcNh6G1PL5TgpbS1MjiJMzs3DMzN5rkm38683UltTcu9t+bL2nHZgo9yLHYexY94Z31ksFAP7i8eqOy/b5q9llzrQwkac3yR57HVYzqvZ3GS8MPSElBgYGAMgvKb2tFwtbj1iD6AeYqSyFYxvg3hRdq4UX8kuOHFjDJr6hWDJ614QsO02ClRPKIDKONyjK9hftOW3prvh6nR1FJnOrDai0eQ9HMW7K4GG3tidSVU3VblFBFyw4gDtIuRfXTM6+1JNT2fPvO2Bo2i043LjY2DxeMmKwbOVlSxcHciPK0Rsu9IsbsUfqk+TUeNK8Lqq7666778+CujrKqlKzgrd2ncc9rYbEwYmLCy7PbeSKwQZYGaZyyESoyJkJQBiRwGa7aVmOGm05dJx+u7it/EPER0Wx+nnu4E/EdFcfhlxM8+G3cTxC9nifLljKksI9BfU3tbWtcQm+gUXdxlv5szSnG9RvRNETYewcUmCkLx2XFopw5zKRIWBC9vVJLL5VuNd8zqxeOw7X/Fu5zwUGsNVi+KMztfZc2FmaCdMki2zLdWtmUMNVJHAivUUqsakdqO4pZwcHZkSupzCgLDo988w328P+qtcq/wAOXJm9Ltoueh2z8JP4z4yP2CjFXDOpaGItv4uqf3rx2PHQ2NR8TOpBR2OOn3e5kinGMnK6NBtDoxghh8Uyw5Xw8T5WEkpzv4jh8SJWBa1w8jCw0ta4NqiwxNXbim979Wjs6MO4f0r6K4KHCzyRwBWTelWE0rOCuKSJV3ZcgpkZrsRoba3NKGKqyqRTe/8Ab9TSdKCi7I892kTu8L2foGP/AD2M0qem3KSXf6I5VLbMeRBJN9PTW7ctrQ42VhxtW+lzCOBe+lcHPa906JW1N74Hx+szfZj8dV+Yw2YR5krDveeyx1UEo6I9v740A7fN/fPn5+ygATnu9X8vNQHAUAooB1AI1AZja37U+j3V5TNfmXyR6LLvgLmy56EeXL5l97VKyTtz5L1I2a7o/f0JGG3f5SfIUJyNnAMeZXtDe4Dl9RluCoHDtOvp3fo9Sj02iJPME2lmPDMB96MLf1kV5apNQzG73X9LF7CDlgbL/dSV0vwEj5JEUsFBVgNSNbg2qRm+HnPZnFXscstrwheEna5V9HtnStMjZSqocxJBHDgBfjrUDLsLUlWjOzSWuuhLx2Ipqk4p3bNNPMDi4kHFUcnuzZbe41eTqJ4uEONn6FTGDWHlL6r1E2ltyKB8jhibBtACLEkdp7qxicfSoT2Jp3M0MHUrR2o2OWwsYs0s8iggHd8eOisOytMDXjWqVJx3aepviqUqVOEZb9RMT0lhR2Qq91JBsFtcctaxVzOjTm4NO6FPL6s4qStqY2SUGQuBoWLAHkWvY15vpEqvSJcb/m5eqm+i2H3WLuLFxkFl4ga2BBsdQP75V7ahWjWgpx4nl6tOVOTjI8u6Q7LVMU880YlMhzKzFrACwCBb5eqABw99YnPYepvTpba0epQbDnGH2xh3schkLDuzo6lR2GxY+i1ZjJS3Gk6bi7M9V2zt1SCFj9ZrexpY8T2ltaeHEzCF92DIXsFU2ZlGYqWBK37bcbCtughVV5q5tGrOGkWelbKONxvR1I9nufGEnIxKRMsLlAz5UW2UAZNzoLXCW1tatVGNOVraGspOWpYdAsLtLDY5E2nN+klwzpghJMsmRgyl48t757ZSTrcC1zawzJp7jCuSegGzdpYPxqXaruIN25lM0wlRjcaoMx0y5uXlAdw0k5TrLZWlrfc391U9d9/wXGwsXhfydsrD4g5d/HFujfhLEsciC/edO82H71dKkZOq2le13yNU7R3/AEPM/C3/APLYjzRf6MdXuXfAX3K7FdsyFTyMwoCw6PfPMN9vD/qrXKv8OXJm9LtokbKWVYcbNGyhUjEMoYXLR4iTIQvIgre9aVHFuEXzX2R1imtqSN0cPtAAZ8Thd3EjjF5oGK3GGw4KTjLec7qSEXXTTuqt2qLvaLu3pr9Xu7iVaemqK3b0W0BhZpJp4XIEquiqbmGXG5WlVwMtjNELDiF9VdqLouolFPh5pHOamotmI2qbRYX7Fv8ArcZUyTs5Nd//AMo5TV1HkQI3JranNvecpRGs5vatXKW1ZGUlYGtXRxTdwjeeB8/rM32Y/GKrc07EeZLw3E9lThVKSh1AJQBQHMUA4UA4UANQGY2t+1Po91eUzX5l8keiy74C+5J6P7VXDs5ZWbMABlt2E8z31jL8XHDSk5K97DG4WVdJRe4uR0sh47p9ePkfGrPrqn4WQOqqnejObVxYlmaQAgNbQ2vooHZ5qpMXWVaq5riW2GpOlTUGWuzOk7ooWRc4GgYGzW778asMNm0qcdmor/XiQq+WRk9qDt9CTiulot+jjN+bkWHoHH112q50rfy46/U5U8qd/fl5FPs7ahjnMzguSDfW172+HCq7DYx06/TT1epOr4VTpKnDQbtraAnkzhcvVC2JvwJN/wCda43ErEVNtK2ljbCYd0IbLdzvsLbAw+e6Fs1uBta1+7vrtgccsMndXucsXhHXas7WK/Gz7yR3tbMxa3K/ZUOvU6SpKfeyVRh0cFHuONcjoPWQgEdh49lTsHmFTDXUdU+BExOEhX1ejI+Nw6SrlcXW97XseBtY1bxzmjNWqRa/JAeW1IO8GjN7R6KqSjo7Bo2DrcBuB1XSxsRp21Jo4zCt+7O3M5VqFe3vR8idjmJW+ijszacTYX9NvXWZZlSUtiKbf0NFgpuO03Y8w2xsfFiV3eO+Y3unWHcAOPC3ZVhQxuHnHSVn9dCJVw1WD3XPUfBR0dgTAnGbrETYhpDHIkE7wPFGDYdVZEzadaxJJzaCs1Kik9Hc5qLW8iYrYWFfC7Txsi4l5cPMogfFSSmeNBuiEYFuxma2bWxF9a5Rbn7sdOBu0oNORo8HsKLGrssYkzSpPhnlmV8TiGQyCOFkaxewILtwtXSM+h92+piS27u2hJw3QAy41himZsFCqjBoJXAu+umVgVyBbaceqeyt6E+gptRbcm23fu7jFT+ZJNrRGQ6V7GhGzTiyHbEHGTQGSSWWRjFHJOiIc7G9ljQX46Va4arLplDha9vsiJWitja4nn9WpAYUBYdHvneG+3h/1VrlW+HLkzel20TdiY3DLDi4MQ8iDECIK0cayEGKUubqWXjoONcqsJtwlBJ29UdoyitpSNUnTnB9cfpl8YzNIwjQmB9zhYlCqX/Si+HJucvlDTjUJ4Kr9NN311f7nZV4Ff0g6YYbEYadUSRZJbxhSq5Fj8cfFCQsG42YLltx7bV1o4SpCabastfxY1nXi4uxj9qj9FhPsG/63GVJkm9rn6I0nujyIKiwreEdlanJu7EzVtBpiw1mro7bjKRvPA8f1mb7MfjqpzTsR5kvD8T2aPhVKSR1AJQBQHMUA4GgFBoBTQGZ2t+1Po91eUzb5l8keiy74C5sh1XE4KAKAKAKAKAKAKAKAKAKAKAawrKMFB0s2I2Kh3ayZNc3C4a3BW7bVZZbjI4artyjchYzDyrQ2U7GLbY+04RlXMyj+F1cegPqPVXp1i8rr6ysn9Vb9CleHxtLRao9G8HeClbDK02z8VvVkLDEYaeONpcraRuDMhA7MtsptfiaRhQXvUWmjnOVTdU3kvF9IFfEYvDY/CusWLMapDGb4glVCgsFIzE5VPUJtl4sOGkK0nO0IvTjwRmVJKF3JEvHbSxGClw8x2diI9n4OF4xlaGWXVVVWdRKcqAINSe25tU2FCFR9pbXA4Oo4q3ArOieN2uzYWdsLLLg4jNJHu3g3jrIHWPMryDyAxAHInjpUqrCgk47Vpad/DfwOUZSettDL9Iuk8UmAbA7qZJVxc07Z1VQqvLM2Q9a4cbwAi3EHWp2Hw0o1VVumrW/Bwq1U47PExd6sCIF6Cw+CdkdXU2ZGDKeTKQQde8ViSTVmZTs7osDtofVcN7Nv665dD/VLz/wdel+iGnbQ+q4b2b/ANdOh/ql5/4HS/0oQ7aH1XDezf8Arp0P9UvP/Bnpf6UQsfjmlYEqqhVyKqLlVVzM9gO9ndtb6sazTioaGJSciIWrdySV2apDCa1ja10bWGmuEW3MyjfeBw/rM32a/jqLmq9yPMlUOJ7OlUhIHXoBL0AUBzoBRQD2FqAQmgM3tX9qfR7q8pm3zL5I9Fl3wFzZDquJwUAUAUAUAUAUAUAUAUAUAUAUAxlrJgy/TmeSKJGjcqS9iVNrjK2hr038NYenXrTjUimrceZTZxVnSpRcHZ3LzZCbQxPR5PFWlbEHENrHJunyCRwetmXThpevS9FQw+J2bJR7uG4pHOpUhdvU0mExEaY7Z0WLdDjhhJFdrgnetubAntJyzW/xc64uLcJSgvdubXV0nvKToHgNsYfFzy7SdxhhHIZmmlDxMbgho1LHKLZjoAANO6pGIlQlCKpLX8nOG2m3LcXGwI8O+E2UpnmguxaBY3yCXJmcQTaG65Rw0vqK41NpTqaJ9/7m+jSPIOneLaXaWKd4zExkylDxGRVjB77hQ3+KrzCRUaMUncg123Mob1IOIXoLCXoZsIWoLCFqGbDS1DawwmuU5bKuZsNJrDSmk0ZSGk10UUom1gLVzVNRd7ixvvA585m+zX8dQc1d4R5kijxPZ0OlUZIHUA5ltQDRQHOgFFAdJeNANJoDN7V/an0e6vK5qn7S+SPQ5c/5C5siVXWZOugpZi6ClmLoKWYugpZi6ClmLoKWYugrFmLoKzZi6ClmLoKWYugpZi6ClmLoKWYujJeEb9hF9p/savWfwj8xU/t9UUefa0Y8/Qx+D27i4UyQ4qeNBchY5pEW5NybKQNa91KjSk7ySbPMKc0rJkOXEuzF2dmcnMWZiWLD94sdb6ca2UYpWW4xd3uTcd0hxkyCObFTSIP3XldlNuFwTr6a0hRpQd4pJmznNqzZwO18RljXfy5YjmiG8e0TDg0Yv1D3i1bdHTu3Za7/AKjal3nHF46SVzJLI0jm13di7GwsLsdToAPRW0YxirR0Rh3buzhnra6MWEz0ujNhC9LiwhesmbCF6XRmw0vWG9NDNgJqNFuTtIWE4112oU0ZEDWrMkprRmbCBqzKN+Ogsb/wOn9Zm+zX8dVmaJKnG3eSKJ7Mh0qkO469AdHOn9/2aAaKA50AUAtABoCvx+Czi1YsgZzE9EM5vSyFxidB1pZC53ToTHSyFzunQuKlkZudl6Hw8qWQudl6JQcqWQuA6P4QdqesUshc6DYmE5p6xSyMXHjY+E5p6xSyM3HjZeE5p61pZC44bOwvNPWKWRi44YDC809YpZC4owWF5p6xSyFxRg8LzT1ilkLi+KYbmnrFZWm4B4rhuafeFZuwHiuG5p94UuxYPFcNzT1isXYDxTDc09YrN2BDg8NzT1il2BpwOF5p6xS7FhDs7C809YpdgYdmYXmnrFLsDRsbCsbDKTyBFLgVujcH8NYuDk3ReDlS4OTdE4eVLg4v0PhpcHB+hkdZuBidDlBuDWLgucBsvd0BZqKAUGgOr8P71oBgoBlAFAFALQC0AUAtALegFvQC0AooCFLiTHhw4F8qKbajsA7Afd57DUAQZ9rvGgk1e9rqUCLrwyPmIPoMn+Ea0BPG0AYhKg0JIs7BLZc2a51GmUn0UBzXauhuFDaabxbE/vLfu19VAH5Te+XKma9rb5eN7W4cbhh5x6gCPahLAEIBprvF7b627dLEc70BOhxCvqrBrcjegIu1pyirqQCTmymxyrFJJYHsuUAv56ArcPtINlAMySdR8rk2ZDOsTWDgFhZuOUWzKdLi4FniNoFGIspt/wDYoPkg6g8OPq15UB0ixqG92UEG1g4J8rKL24Ens56UBJvQEXGFs0aq5XMxuVy3sEY26wI4gUBwxTzxRu+8Rgis1mjOZgoJsWVwL6WuF9FAdcbjijZcoOg4yKh1zAaHvAF+/uoBv5Q1tZbXAJ3qada1z/M27qA5rtTtyrbj+2j4cQfNbWgJeJOg/wD0n41oDrQCUAlAJQCUAhoBKAKAKAdmNAAoBtqALUAWoAoBaAKAWgFFAFALQC0BEKK0YjdGIyhWFm7LcCveOygI35NhN8yswPZuwt7cLsqBjbvPnvQE/OtrZDYcBkNh5hagEun8B9mfhQC5kvfIb8fIPHnwoAun8B9mfhQDhKo4Kw/wH4UByxQDgeWCpzKQhNjYqbgixBDMPTQHBoLkZmc6qTaIAnIwYKTa9rgUBKJQm5Q357s37O7uHqoBoWP6P/L5cOygOu/HJvut8KA4YkZspBdSpJBCE8VKkEEd9AcZ4WdWRpHswKm0QBsRY205GgJMm7Y3aO574yfRqO+gEAjAsI9OW7NvdQDVjiHCK3mj9HKgHSPmsAG4qdQQLBgTx81Ad6ASgEoAoBKASgCgEoBaAUUAooBLUAUAUAUAWoBbUAUAUAtAFALQAKAWgAUAtAFAFALQBQBQBQBQBQCGgCgCgEoAoBKAKASgCgEoAoAtQCWoAtQC2oAtQCigP//Z",
                "https://img.freepik.com/vector-gratis/plantilla-banner-horizontal-degradado-ventas-buen-fin_23-2150873588.jpg",
                "https://static.vecteezy.com/system/resources/previews/002/506/587/non_2x/flash-sale-discount-banner-promotion-background-vector.jpg",
                "https://img.freepik.com/vector-premium/promocion-banner-super-venta_131000-345.jpg",
                "https://img.freepik.com/vector-premium/promocion-oferta-especial-descuento-diseno-plantilla-banner-super-venta_165143-1029.jpg")

            LazyRow(modifier = Modifier.fillMaxWidth().padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                item { CardPromo(listadoPromociones[0]) }
                item { CardPromo(listadoPromociones[1]) }
                item { CardPromo(listadoPromociones[2]) }
                item { CardPromo(listadoPromociones[3]) }
                item { CardPromo(listadoPromociones[4]) }

            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}


@Composable
fun CardPromo(urlImage: String){
    Card(modifier = Modifier
        .height(180.dp)
        .width(300.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(urlImage),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop)
    }
}