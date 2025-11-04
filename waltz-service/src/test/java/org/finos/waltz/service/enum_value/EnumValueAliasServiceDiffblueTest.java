package org.finos.waltz.service.enum_value;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import org.finos.waltz.common.Aliases;
import org.finos.waltz.data.enum_value.EnumValueAliasDao;
import org.finos.waltz.model.enum_value.EnumValueKind;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnumValueAliasServiceDiffblueTest {
  /**
   * Method under test: {@link EnumValueAliasService#mkAliases(EnumValueKind)}
   */
  @Test
  void testMkAliases() {
    // Arrange
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    Aliases<Object> aliases = new Aliases<>();
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(aliases);

    // Act
    Aliases<String> actualMkAliasesResult = (new EnumValueAliasService(enumValueAliasDao))
        .mkAliases(EnumValueKind.TRANSPORT_KIND);

    // Assert
    verify(enumValueAliasDao).mkAliases(eq(EnumValueKind.TRANSPORT_KIND), isA(Function.class));
    assertSame(aliases, actualMkAliasesResult);
  }

  /**
   * Method under test:
   * {@link EnumValueAliasService#mkAliases(EnumValueKind, Function)}
   */
  @Test
  void testMkAliases2() {
    // Arrange
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    Aliases<Object> aliases = new Aliases<>();
    when(enumValueAliasDao.mkAliases(Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(aliases);

    // Act
    Aliases<Object> actualMkAliasesResult = (new EnumValueAliasService(enumValueAliasDao))
        .<Object>mkAliases(EnumValueKind.TRANSPORT_KIND, mock(Function.class));

    // Assert
    verify(enumValueAliasDao).mkAliases(eq(EnumValueKind.TRANSPORT_KIND), isA(Function.class));
    assertSame(aliases, actualMkAliasesResult);
  }
}
