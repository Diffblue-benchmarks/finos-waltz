package org.finos.waltz.model.attestation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.IdSelectionOptions;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationInstanceInfo.Builder;
import org.finos.waltz.model.attestation.ImmutableApplicationAttestationInstanceInfo.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableApplicationAttestationInstanceInfoDiffblueTest {
  /**
   * Test Builder {@link Builder#filters(ApplicationAttestationSummaryFilters)}.
   * <ul>
   *   <li>When {@link ImmutableApplicationAttestationSummaryFilters.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#filters(ApplicationAttestationSummaryFilters)}
   */
  @Test
  @DisplayName("Test Builder filters(ApplicationAttestationSummaryFilters); when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.filters(ApplicationAttestationSummaryFilters)"})
  void testBuilderFilters_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.filters(new ImmutableApplicationAttestationSummaryFilters.Json()));
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceInfo)}.
   * <ul>
   *   <li>Given {@link ImmutableApplicationAttestationSummaryFilters.Json} (default constructor).</li>
   *   <li>Then builder build filters is {@link ImmutableApplicationAttestationSummaryFilters.Json} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceInfo); given Json (default constructor); then builder build filters is Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceInfo)"})
  void testBuilderFrom_givenJson_thenBuilderBuildFiltersIsJson() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceInfo.builder();
    ApplicationAttestationInstanceInfo instance = mock(ApplicationAttestationInstanceInfo.class);
    ImmutableApplicationAttestationSummaryFilters.Json json = new ImmutableApplicationAttestationSummaryFilters.Json();
    when(instance.filters()).thenReturn(json);
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).filters();
    verify(instance).selectionOptions();
    assertSame(json, builderResult.build().filters());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ApplicationAttestationInstanceInfo)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ApplicationAttestationInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder from(ApplicationAttestationInstanceInfo); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ApplicationAttestationInstanceInfo)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceInfo.builder();
    ApplicationAttestationInstanceInfo instance = mock(ApplicationAttestationInstanceInfo.class);
    when(instance.filters()).thenThrow(new IllegalStateException("instance"));
    when(instance.selectionOptions()).thenReturn(mock(IdSelectionOptions.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).filters();
    verify(instance).selectionOptions();
  }

  /**
   * Test Builder {@link Builder#selectionOptions(IdSelectionOptions)}.
   * <ul>
   *   <li>When {@link IdSelectionOptions}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#selectionOptions(IdSelectionOptions)}
   */
  @Test
  @DisplayName("Test Builder selectionOptions(IdSelectionOptions); when IdSelectionOptions; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.selectionOptions(IdSelectionOptions)"})
  void testBuilderSelectionOptions_whenIdSelectionOptions_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableApplicationAttestationInstanceInfo.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.selectionOptions(mock(IdSelectionOptions.class)));
  }

  /**
   * Test Json {@link Json#filters()}.
   * <p>
   * Method under test: {@link Json#filters()}
   */
  @Test
  @DisplayName("Test Json filters()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApplicationAttestationSummaryFilters Json.filters()"})
  void testJsonFilters() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).filters());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setFilters(ApplicationAttestationSummaryFilters)}
   *   <li>{@link Json#setSelectionOptions(IdSelectionOptions)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setFilters(ApplicationAttestationSummaryFilters)",
      "void Json.setSelectionOptions(IdSelectionOptions)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setFilters(new ImmutableApplicationAttestationSummaryFilters.Json());
    actualJson.setSelectionOptions(null);

    // Assert
    assertFalse(((ImmutableApplicationAttestationSummaryFilters.Json) actualJson.filters).appCriticality.isPresent());
  }

  /**
   * Test Json {@link Json#selectionOptions()}.
   * <p>
   * Method under test: {@link Json#selectionOptions()}
   */
  @Test
  @DisplayName("Test Json selectionOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"IdSelectionOptions Json.selectionOptions()"})
  void testJsonSelectionOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).selectionOptions());
  }
}
