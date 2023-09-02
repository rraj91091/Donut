package com.project.donut.pgp

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * Test key ID: 3402CC2E5CFF76D9221B987F6AC78F4F9C7734F6
 * Secret Key ID (Signing & Compression) : 6AC78F4F9C7734F6
 * Secret Sub-Key ID (Encryption) : 53C73919D73F887A
 */
class PgpServiceTest {

    private val pgpService = PgpService()
    private val passphrase = "password"
    private val plaintext = "PLAINTEXT"

    @Test
    fun `PGP key pair should encrypt and decrypt correctly`() {
        val ciphertext = pgpService.encrypt(plaintext, pgpPublicKey)
        val decryptedPlaintext = pgpService.decrypt(ciphertext, pgpPrivateKey, passphrase)

        assertEquals(plaintext, decryptedPlaintext)
    }

    private val pgpPublicKey = """
        -----BEGIN PGP PUBLIC KEY BLOCK-----

        mQINBGQ9HzgBEAChwRXzONlfiSP4vY3rIVUvAxiyN6BH+3n5Dg+r2VoBj1T5fccG
        ZPHUq0jazewuSaS8u6Fc0TJLPa+pkkxD/pdGsEkYfGpYQIPxK+/2uV1WYPBeYvmV
        PLFky8m85MKeywU45QkZyOvXP0NrimWWdgbheArN96aVBD0OckxieoqwxGWzpr5f
        RvodJ+58oxlsTCoDXugQzR895vywfoa8v3VuuZ/WvDwByqfQzDCo8SNZ6QQHb26A
        +2eX7CkWj337+2QxdrTigbaurtZsTcDUi3OXkonAz9OYcKo6QfVtOYHeM5F4u1AS
        uj9RIsMFo5KrlOUdcjbkqh2k+DtnfaLMv8l2Aloe0/VosgOjGT+BVndXzI2R2rMw
        645KnuBSX/V2VCBwO11DqdbhQcfN+ff8YyVpquxj1uY9Wwis+huha88gx1rzigYo
        nhKpKA6A4qbHIoAgusqS9S373Esf+hdkWr0OeUxbNELd/AA2/fgoFl7TKXEPh5jj
        dX6mvcMfyqj7UdRIPEtSiiaB9KEyCBnH0HzsolsCNdE/cYnaIn7E2YBib9BSrLji
        VxySCmFLoaP4KPVUeCDq74HIoREf5gjVzVcYXzMv5emoguk0sD1Ygiq3CrPM9cmF
        c4ZO1DbQNozpLyNjODDscAaHwQ1iQ30ngIxGpjcs02GyrQRcqE0QdSPLswARAQAB
        tE5yYWplbmRyYW4gKGtleSBmb3IgZG9udXQgYXBwbGljYXRpb24gdGVzdGluZykg
        PHJhamVuZHJhbi5yYWphcmFqYW5AenVobGtlLmNvbT6JAlEEEwEIADsWIQQ0Aswu
        XP922SIbmH9qx49PnHc09gUCZD0fOAIbAwULCQgHAgIiAgYVCgkICwIEFgIDAQIe
        BwIXgAAKCRBqx49PnHc09s8MD/919oyGEto6ogdL1SWDK7Mupw+BH6iGbY8+tCtz
        3WIhOJ2OncDeL1Tnp/erjjsF6kD93JL9LZLNx89vNgVJxTBrh7Rai7CfiD5Oi/34
        OjOxo2z5yGpJA34+snWn7FUR589dktWYa/FjzJtrGBXlJ4pP0GikWPlbYkhoCy1n
        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
        =aXbc
        -----END PGP PUBLIC KEY BLOCK-----
    """.trimIndent()

    private val pgpPrivateKey = """
        -----BEGIN PGP PRIVATE KEY BLOCK-----

        lQdGBGQ9HzgBEAChwRXzONlfiSP4vY3rIVUvAxiyN6BH+3n5Dg+r2VoBj1T5fccG
        ZPHUq0jazewuSaS8u6Fc0TJLPa+pkkxD/pdGsEkYfGpYQIPxK+/2uV1WYPBeYvmV
        PLFky8m85MKeywU45QkZyOvXP0NrimWWdgbheArN96aVBD0OckxieoqwxGWzpr5f
        RvodJ+58oxlsTCoDXugQzR895vywfoa8v3VuuZ/WvDwByqfQzDCo8SNZ6QQHb26A
        +2eX7CkWj337+2QxdrTigbaurtZsTcDUi3OXkonAz9OYcKo6QfVtOYHeM5F4u1AS
        uj9RIsMFo5KrlOUdcjbkqh2k+DtnfaLMv8l2Aloe0/VosgOjGT+BVndXzI2R2rMw
        645KnuBSX/V2VCBwO11DqdbhQcfN+ff8YyVpquxj1uY9Wwis+huha88gx1rzigYo
        nhKpKA6A4qbHIoAgusqS9S373Esf+hdkWr0OeUxbNELd/AA2/fgoFl7TKXEPh5jj
        dX6mvcMfyqj7UdRIPEtSiiaB9KEyCBnH0HzsolsCNdE/cYnaIn7E2YBib9BSrLji
        VxySCmFLoaP4KPVUeCDq74HIoREf5gjVzVcYXzMv5emoguk0sD1Ygiq3CrPM9cmF
        c4ZO1DbQNozpLyNjODDscAaHwQ1iQ30ngIxGpjcs02GyrQRcqE0QdSPLswARAQAB
        /gcDAk6GDxg4wT/e1TABxOsxXO9ZZ5hiRGQ1UjnQy0FpLUPScgYNKWoaWKZwld3z
        chZy9wUKBPtdPGPLYX258gdx2xG/PjltDTCK1zKet5hGJFSLuX7OlSTAw0EN1efk
        LoLxpdFNaEa1DPf9yE1ytwDWzgM+ro124I16DakB2duZqtKx4QGGJKSKESu2h49a
        O48aR/CnF1f4hTHSqQUe8OlHZEPrafNv6vp3nU0VGBfHnAbK0Bf/fY7+Fw0BN0lx
        e0/Z3FOxCWk12fV9FxtPQHiwDIzk07yf7dFf4fylt7ynrpKR6cu1VLW4FbgU0PsK
        idjFpgWxetC/Xwctw03K/hvthAUe+jDS5KNCW96CGE6JxNuC+pIZR8Xez4cFH3z2
        eWTm9ntQ8i16cJn2kqN9iqoL6WkbmmptEyI5r8lElXYTyDpnUygmhNdjppOOmOog
        omoSPhEhg0EMBc0ubU0pfCxZQPv9JAcedUfEF4Qcr2ZzM9s4Hxw7tbw1+pdEWU06
        ejnGdDkbjdQ5iLz1VkwspDW7f77VcE9JjsHv9phUIeFQZvVfbAuL8VP2lCyL7oz9
        l8K+lKjP0HKCFhztFX4WrapEyJhLywnKmsrjpgCY7sxdbJ/+Voq1oK8nzSuT3sWt
        IlXEkKL97K2WdSKWbMgEP9tvwjwcfv3uHulZ1k8BykHfu0jvB9YimAXoWt/my+61
        6h9VgKk2nuEwF2oaHavudxlVz43gwb1kY8khSMOn29X/t9PI5iQpwzswYIywpFcc
        03AfU+opcDgcvQjqgM6m+6Oz3fLJM9i7sA4z610a2dDRyREr/1NpFp0t0B1223tz
        6Fu/WKK2Ileq6GwLOGVpzINDJEa/2jdubBgTuMNfPKtVuwx+seTPTrfeesHC51aH
        KxhKPkG/jYUARlzVIH8wsJXHXItRhkTsux+NilmEDkAOX3aZXqqHA4N5iDToK3nt
        DqJjhZ52owME0nj2C1wV4nk37hzYuRvva7nE/gc+NkZxcL4kQ7FDntmASmnVR6ra
        oqKDG94dFk/rBzIdAnKpNjP/T3j3mO7uNk7xhunJe++8zkNJSePHZmTpAsFKP7Fi
        B6jo6ad3sWkxSaurXjZ/5EbLzbDwOVLsqrGttyWr6BxhyC1P0oXzhZbghqVojTLH
        nI5RZxIS4dq6jTdGyXCpFJF0oEm8rSGt5RgmQhI2GIoxG7693Mf6kcNhj7N01WjF
        Le4+qff9kO3gAaWvJJOx9ZeO7yT9s0Z301B76/9tBrTb3oVnmRZxiA8j4ao3kLP6
        0iKP+83gnHPrU5im/xKa3MYtDvNk9AuTAY6OtQv0Ae9vlzoWXD6XllJZeASMorGj
        FbbK/Iti0OEYFJKcPltL11rii6r4B9m0iAmapEhdaUCPUETKJfBBi3Vk5zID6NWL
        WSEaS0XU3sRdc8WbTT4e1GUPMw8QzQYs3mYxuPeZ2rUM/un062gx3Cp1YIkv7axq
        XpiI3VYa+Bo4HWZ/Bf2iNsKZ5N4++cRH9SN3x3wDSF8YNwADK5bqjf7BpUBG1bAg
        ReER5OzhWQuj+jz40Fomsw+3UYprh0NYfOMrmHAvCJtxlumss4nDXwRLHgkgyhr/
        Xn8XACtNv9SYOgm59BQ23x5DRV87KOdZ20lmixcVhLhw1lcpqoXFPOFXldcTtXtj
        xuB300AItW6sqPNRvaW6yP27sv5nBHugYFD3CsfHV60nEDPp+CHv/6BDSXHVAWwV
        z8jjuqJeB6zUYmHO/DsngC9/KqBmZmk0nlW88LDuHyP7fgGzgb3Y2Vq0TnJhamVu
        ZHJhbiAoa2V5IGZvciBkb251dCBhcHBsaWNhdGlvbiB0ZXN0aW5nKSA8cmFqZW5k
        cmFuLnJhamFyYWphbkB6dWhsa2UuY29tPokCUQQTAQgAOxYhBDQCzC5c/3bZIhuY
        f2rHj0+cdzT2BQJkPR84AhsDBQsJCAcCAiICBhUKCQgLAgQWAgMBAh4HAheAAAoJ
        EGrHj0+cdzT2zwwP/3X2jIYS2jqiB0vVJYMrsy6nD4EfqIZtjz60K3PdYiE4nY6d
        wN4vVOen96uOOwXqQP3ckv0tks3Hz282BUnFMGuHtFqLsJ+IPk6L/fg6M7GjbPnI
        akkDfj6ydafsVRHnz12S1Zhr8WPMm2sYFeUnik/QaKRY+VtiSGgLLWcvadEzYSzF
        0E0TfTqXoBKZQcFbbeK7d03ox3TJ2I2A34iryzghspgOzVF0jyIDKYjlNdLWZXbC
        fPfhKLDvHn1Ubr/3g/l5AjBI1RiuGYD6OKddI26qBpRToAvF3D8VhkzUGJJTSeH2
        kAMsMKUiptWM8uh2eN4UL3bP9VrdKlBNYmYtDlx6zKm5z1gWtDXcsI0/hB2KeB+v
        noA5GRQTV6QISpUu8/61u2/2kx7RRcvCCrmq8LYdd1jDPhP9pHMRlOJdm4lduvaq
        4qDsLGXsXNyrct+sYTFBY74/ZpMBiVdbBrN1jKzq2xcggzWNqXsIp7V8TP7H6/D+
        5FHIU094sBB/3nNIhSVniOpaZDZAtwWuXZ1kNZRdlB9Jmp1KZ6Iy3SW0PNVLKLqm
        gMJ4taXQpVU/QgSaGohmSrw/fEM3i7rppeHYTOjPeoQppt+HLzsJj+2keSrH7/j3
        I7jSaQQBHjMaNZcSMPapFTtYUkiG6fT9MP9JXWpDkiTrtyl1eRWrakrk1gGznQdG
        BGQ9HzgBEACbCC5fNjav9VViUqAAJOmV1jZ+XEyKSkd8NoACkwWh1BerDFNJT+TT
        /MC89BxHV6+wW3lCgnUjtXWjzXn5a4iSEwjHltswzlH/B/np2poDj3Irz2V4Wm1r
        k71JihklaGWTZ+VMNYPhiFMczcBY6Uu0trEl1ljcb0OnZYZqhb5u8EH8E3XNQVt6
        5/KexEWbraXwVPpuFCwNRrV65Sre1bLs6/rmMGClHYIp2+Cfe54uGRbi4Z2duFBW
        zwCVz/J5IINgIgK7NNll1lTNI+AkoPoC5JoYX1fdI0GMw8BZzZJJfaXctRqPjgc4
        rQD/NCa9Z+EnlGCuSELgjXbLXsN0ozx/RLmMGeV2i4wdwbDPEveSRxRoB+KqhzwF
        Bsx638I6Gz3ZCUgeOuv1R5dN3BvB3iRqrgXQUVtqyzBA7ZW8/x28Z0301psbETGH
        Y1Qn/WHYVuBfMQl+j5VWLp2/PQpKAsPTIrRCcV/CqLaPMiUf/JgV+Uia1lPEcxBb
        kJ2u+tCUrUIswhOZLEfQ7PMUzGmQ0gxOSxyDkW4bx+sPyOEoKnPbuaJ+QWw4k4tU
        BPwq5gzGlbzAwlUwKe+obguPBiiHEuL3d79RI2mX8AyBXK5LgIai1ul6Heg2FA5+
        oLDGrD9iexcD8uEAA1VlrFcTn1UMhbCDUa7lXBJIKnlv2F1HYv2bQwARAQAB/gcD
        Ak2g9ATcBOSf1e8Hma8ZUP1/hkcSJx6Bx/rQV1zePKdrOO33MAHU4MhJIMc4aSL3
        /MwvKGm6CzsQNhTSMAjrtR8vu7dEqxJ/W6mgdlJuqQUI6TELb0ZFCfKjthVJnqyj
        MWUAmq/z6/c15niLKxX+OaL4QdQECq9sywaf5Kx5ngRF6pHcB5Vu7cz1crkjX/bE
        AISS8OJnNbqYCP5wt6Xq680LMRUL1MeZyKFPwxUKYlN/L/4CdnB4hNHPKSNzVcNP
        MtaH3tlA3XuHYUWDNXe044oJnlBOLtqC8FYoX2itKmMfRDr9RQtPDyPHrwH4IfTX
        B0qYAC4axWJdlmb+WZAolWbWGfOXU4XxsachXM6+w37SSyK5foz6/8yaOn9+mnUj
        HszEaVTSXNCCvRonxsKnB9SvCPt8YsdvFCLHhzCotlJhw2lJUNTqUdFiOa49RP4B
        LtNAyUI5F2Aprp5U/SQF/09CR6NICTL9GP2l1gYesBqQCF2TwMTCoJ6USl9oMtKy
        OC5l5cWr/bMf8yz5p4PhDNlkr16d+OmKIduXKsR6ygYmE71RTDc1iE4f7QRMCECG
        /ImTQahrn3iRtgjZGmGF/mHEJjnQ8jNp0iAey0nXiZXN0LwbtcXXgIXgX5l4H8yY
        eXkTEF2s1VjyVnG/92tGzslg4qV3sWDxOw706HkPl/Tey2UxbRUxgzK77ZGDjeQ2
        1mu6qWIK6puG9HTl+VjdPbD/gFuieGwI1nNVE0kUWPYJd4AM94ZkOzrkt9ja8zll
        pQaF3RH4eD9ERM/iXz6VxDX6sxYlemB2cjOfFfqLm5qmE9/+sg2QjrIw2gtv3+4N
        I7jpMQu31gUgbFDjflep49xybaytvYtm3eZ3GvaGpuiMo1bwtbe90l6S2KtN0/y3
        Zw8p8ECTePjlbiYNUHENpoARy1EReS6qRugBq+ecOUyiIxW70cM8DtHTm200+OoM
        8VZ3pr7wR9pVxSodl2Nh1ileDe2lSr1SVzHVdALDHSPTg+oBgiW9GUsVvEewpzp7
        pZjG/ZdW7UooCSbEhpERhvpIy7d2heT8n6ebrrUZKzk8RLFenD3HEgVjBmQFpCXs
        Dtqz8G+muZeISTrMXsOmTlDspwj/+YgiP+i33sNwlFBYZxigaeGkmhnkRXFRD2ge
        bRu1x5AQilTpebr32zccme+LNLbr34n91yhw04WiQo0vnsg17JuVfzITYp38308K
        hSkd4vFTnuTh0BsqmXQaBUpLpR4FLQegoBLVkMb9/VNa2hxJOkZfn1u2i8U93Qf/
        6UCZOKshgAKvDehTa9kr27vid5vQtFV6RSdnda7V8a2C5mCvpFKnaBDx6Te9+dre
        Sf+Pnpnr3n1rya0agM9KHM34xCZpGVbx90cMK2Znt/LDC762Exw5/hkPvhVGYrw3
        p2hseYuveBHif0wX9jDrvgVmL+brzzCXBvW0v3E7z9VVya6c/mgugNiAPnmI4NfM
        HMYVqeQek48O/jmE//vrO8VmcaHjWicGO3G8mVLcGxwN0u6r92YPMyYX/HIBHi2b
        IOtDkDvtwTuUuwvIV5HJa9eBQCM5GqLBd5TMCQ7hizbOKGG5JPwGQyfm/dEkevDa
        NG7+R9RtHFbMJEHNnO4eLJGnnsE0CIcNJHaGmpONVSubMxgDrnXUPW40dYYTbvQk
        X4ygSK0lv2AwVB4ZbT3kddmmTnkCEspZZbk259r8uPRRCWwkg30E8C5g+a83GTA7
        s9YKVFQHHsp+ES7mIOCo8N6WjXl4A7CYbcpjMcAmhcpzMtjcYPeJAjYEGAEIACAW
        IQQ0AswuXP922SIbmH9qx49PnHc09gUCZD0fOAIbDAAKCRBqx49PnHc09q6WD/4+
        3Y3kxw2B423G6Ca2hXKZws77FfzgeW3Sihiqsn8FcpkThX9mfBGjMx0OCkYLhi0g
        zCiiC8pYawGgG2U0JxaGAc3aJ9Fi6ZITJNu8ewHLIvA2ra3mGczjQ6uKKAaASP/j
        h5ed1S4h3CDL5XfQeF80cb8Q0RMJYpq1s6SEMeWP7r4/43I+cowyzE2L1G0Gkd90
        TE2XFgM6lVfRvoto2vxzdus/UirSy9MRQzzRpDAhw8vFzdJYVbKxtMOesmhk+fCO
        ylUwAQhhvNF5IMU+VC/9Ra2r0C+4cjQNZpHLBYmZjAfwFLm5wbQGs64rxXdOL0cW
        UPfyWUF9iuiI1uOtf/b0rOYrZy0XU/9HRIxJyAAwDvcSCsMlNdZ0Tvf2qlPwppZM
        dmyvDKSA5eO7c1yVs4+3J3qf7A49Bb7beIK3ZKRrdOSWk6HVXS4yy6aMgFdZEU/B
        BG0XEI+E5W0rmYHsvz+QnWec10N5C4hTtKLdlxoq3sKA/O/WGUG43ZK7ISeJP8GX
        lEauN0HZYMrE/ZLZLfD4zKB51tHkHXIsMCYZjxwLa0pqGmNKsUM9oFaoJslmSHRR
        p1OJ+/EbmUnPkMuwIG9ftTpNcWMt4CkTE3UKq2bGKhbBdDIAaIwKtNPZ8GniWxBE
        jt4X3olDT1dqhqsS7QOKmgVCcG6yPBSJF0jZeC9rZw==
        =DxGK
        -----END PGP PRIVATE KEY BLOCK-----
    """.trimIndent()
}

