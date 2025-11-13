package org.finos.waltz.service.enum_value;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Function;
import org.finos.waltz.common.Aliases;
import org.finos.waltz.data.enum_value.EnumValueAliasDao;
import org.finos.waltz.model.enum_value.EnumValueKind;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EnumValueAliasServiceDiffblueTest {
  /**
   * Test {@link EnumValueAliasService#mkAliases(EnumValueKind)} with {@code kind}.
   *
   * <p>Method under test: {@link EnumValueAliasService#mkAliases(EnumValueKind)}
   */
  @Test
  @DisplayName("Test mkAliases(EnumValueKind) with 'kind'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aliases EnumValueAliasService.mkAliases(EnumValueKind)"})
  void testMkAliasesWithKind() {
    // Arrange
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    Aliases<Object> aliases = new Aliases<>();
    when(enumValueAliasDao.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(aliases);

    // Act
    Aliases<String> actualMkAliasesResult =
        new EnumValueAliasService(enumValueAliasDao).mkAliases(EnumValueKind.TRANSPORT_KIND);

    // Assert
    verify(enumValueAliasDao).mkAliases(eq(EnumValueKind.TRANSPORT_KIND), isA(Function.class));
    assertSame(aliases, actualMkAliasesResult);
  }

  /**
   * Test {@link EnumValueAliasService#mkAliases(EnumValueKind, Function)} with {@code kind}, {@code
   * mapper}.
   *
   * <p>Method under test: {@link EnumValueAliasService#mkAliases(EnumValueKind, Function)}
   */
  @Test
  @DisplayName("Test mkAliases(EnumValueKind, Function) with 'kind', 'mapper'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Aliases EnumValueAliasService.mkAliases(EnumValueKind, Function)"})
  void testMkAliasesWithKindMapper() {
    // Arrange
    EnumValueAliasDao enumValueAliasDao = mock(EnumValueAliasDao.class);
    Aliases<Object> aliases = new Aliases<>();
    when(enumValueAliasDao.mkAliases(
            Mockito.<EnumValueKind>any(), Mockito.<Function<String, Object>>any()))
        .thenReturn(aliases);

    // Act
    Aliases<Object> actualMkAliasesResult =
        new EnumValueAliasService(enumValueAliasDao)
            .mkAliases(EnumValueKind.TRANSPORT_KIND, mock(Function.class));

    // Assert
    verify(enumValueAliasDao).mkAliases(eq(EnumValueKind.TRANSPORT_KIND), isA(Function.class));
    assertSame(aliases, actualMkAliasesResult);
  }
}
