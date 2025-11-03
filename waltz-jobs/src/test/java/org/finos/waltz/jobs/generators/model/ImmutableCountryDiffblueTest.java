package org.finos.waltz.jobs.generators.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.jobs.generators.model.ImmutableCountry.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableCountryDiffblueTest {
  /**
   * Test Builder {@link Builder#code(String)}.
   * <p>
   * Method under test: {@link Builder#code(String)}
   */
  @Test
  @DisplayName("Test Builder code(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.code(String)"})
  void testBuilderCode() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.code("Code"));
  }

  /**
   * Test Builder {@link Builder#from(Country)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Country)}
   */
  @Test
  @DisplayName("Test Builder from(Country); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Country)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();
    Country instance = mock(Country.class);
    when(instance.regionCode()).thenThrow(new IllegalStateException("instance"));
    when(instance.region()).thenReturn("us-east-2");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).code();
    verify(instance).name();
    verify(instance).region();
    verify(instance).regionCode();
  }

  /**
   * Test Builder {@link Builder#from(Country)}.
   * <ul>
   *   <li>When {@link Country} {@link Country#regionCode()} return {@code us-east-2}.</li>
   *   <li>Then builder build code is {@code Code}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(Country)}
   */
  @Test
  @DisplayName("Test Builder from(Country); when Country regionCode() return 'us-east-2'; then builder build code is 'Code'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(Country)"})
  void testBuilderFrom_whenCountryRegionCodeReturnUsEast2_thenBuilderBuildCodeIsCode() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();
    Country instance = mock(Country.class);
    when(instance.regionCode()).thenReturn("us-east-2");
    when(instance.region()).thenReturn("us-east-2");
    when(instance.code()).thenReturn("Code");
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).code();
    verify(instance).name();
    verify(instance).region();
    verify(instance).regionCode();
    ImmutableCountry buildResult = builderResult.build();
    assertEquals("Code", buildResult.code());
    assertEquals("Name", buildResult.name());
    assertEquals("us-east-2", buildResult.region());
    assertEquals("us-east-2", buildResult.regionCode());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#region(String)}.
   * <p>
   * Method under test: {@link Builder#region(String)}
   */
  @Test
  @DisplayName("Test Builder region(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.region(String)"})
  void testBuilderRegion() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.region("us-east-2"));
  }

  /**
   * Test Builder {@link Builder#regionCode(String)}.
   * <p>
   * Method under test: {@link Builder#regionCode(String)}
   */
  @Test
  @DisplayName("Test Builder regionCode(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.regionCode(String)"})
  void testBuilderRegionCode() {
    // Arrange
    Builder builderResult = ImmutableCountry.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.regionCode("us-east-2"));
  }
}
